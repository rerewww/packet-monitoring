package Pcap;

import Network.model.*;
import Network.PacketContainer;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.packet.format.FormatUtils;
import org.jnetpcap.protocol.lan.Ethernet;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.tcpip.Http;
import org.jnetpcap.protocol.tcpip.Tcp;
import org.jnetpcap.protocol.tcpip.Udp;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by son on 2018-10-29.
 */
@Slf4j
public class JnetPcapWindows implements JnetPcacp {
    private static final int SNAP_LEN = 64 * 1024; // 크기대로 패킷을 자른다.
    private static final int FLAG = Pcap.MODE_NON_PROMISCUOUS;
    private static final int TIMEOUT = 10 * 1000; // ms
    private static final StringBuilder ERROR_BUF = new StringBuilder();
    @Setter
    private PcapIf device;
    @Getter
    private List<PcapIf> allDevices = new ArrayList<>();
    private int detectLoop;

    public JnetPcapWindows(final int detectLoop) {
        this.detectLoop = detectLoop;
        if (Pcap.findAllDevs(this.allDevices, ERROR_BUF) != Pcap.OK) {
            log.warn("[Error]: " + ERROR_BUF.toString());
        }
    }

    @Override
    public boolean activityDevice(final String id) {
        for (PcapIf device : this.allDevices) {
            if (device.getName().equals(id)) {
                setDevice(device);
                return true;
            }
        }
        return false;
    }

    /**
     * 클라이언트에서 요청받으면, LOOP_VAL만큼 패킷을 가져온다.
     * @return PacketContainer
     */
    @Override
    public PacketContainer analyze(final PacketContainer packetContainer) {
        Ethernet ethernet = new Ethernet();
        Ip4 ip4 = new Ip4();
        Tcp tcp = new Tcp();
        Udp udp = new Udp();
        Http http = new Http();

        Pcap pcap = Pcap.openLive(device.getName(), SNAP_LEN, FLAG, TIMEOUT, ERROR_BUF);
        pcap.loop(this.detectLoop, new PcapPacketHandler<String>() {
            public void nextPacket(final PcapPacket pcapPacket, String user) {
                if (pcapPacket.hasHeader(ethernet) && pcapPacket.hasHeader(ip4) && pcapPacket.hasHeader(udp)) {
                    packetContainer.setPackets(new Packet(
                            udp.getName(),
                            FormatUtils.ip(ip4.source()),
                            FormatUtils.ip(ip4.destination()),
                            udp.source(),
                            udp.destination(),
                            pcapPacket.getTotalSize(),
                            pcapPacket.toHexdump(),
                            new EthernetModel(FormatUtils.mac(ethernet.source()), FormatUtils.mac(ethernet.destination())),
                            new IpModel(ip4.version(), ip4.getHeaderLength(), ip4.getLength(), ip4.getId(), StringUtils.collectionToDelimitedString(ip4.flagsEnum(), " ")
                                    , ip4.ttl(), tcp.getNicname(), ip4.checksum(), FormatUtils.ip(ip4.source()), FormatUtils.ip(ip4.destination())),
                            new UdpModel(udp.source(), udp.destination(), udp.length())
                    ));
                }
                if (pcapPacket.hasHeader(ethernet) && pcapPacket.hasHeader(ip4) && pcapPacket.hasHeader(tcp)) {
                    String tcpFlags = StringUtils.collectionToDelimitedString(tcp.flagsEnum(), " ");
                    packetContainer.setPackets(new Packet(
                            tcp.getName(),
                            FormatUtils.ip(ip4.source()),
                            FormatUtils.ip(ip4.destination()),
                            tcp.source(),
                            tcp.destination(),
                            tcpFlags,
                            pcapPacket.getTotalSize(),
                            pcapPacket.toHexdump(),
                            new EthernetModel(FormatUtils.mac(ethernet.source()), FormatUtils.mac(ethernet.destination())),
                            new IpModel(ip4.version(), ip4.getHeaderLength(), ip4.getLength(), ip4.getId(), StringUtils.collectionToDelimitedString(ip4.flagsEnum(), " ")
                                    , ip4.ttl(), tcp.getNicname(), ip4.checksum(), FormatUtils.ip(ip4.source()), FormatUtils.ip(ip4.destination())),
                            new TcpModel(tcp.source(), tcp.destination(), tcp.seq(), tcp.ack(), tcp.getOffset(), tcp.window(), tcp.urgent(), tcpFlags)
                    ));
                }

                if (pcapPacket.hasHeader(http)) {
                    Packet packet = new Packet();
                    packet.setProtocol(http.getName());
                    packet.setUrl(http.fieldValue(Http.Request.Host)+ http.fieldValue(Http.Request.RequestUrl));
                    packetContainer.setPackets(packet);
                }
            }
        }, null);
        pcap.close();
        return packetContainer;
    }

    @Override
    public List<PcapIf> getNetworkDevices() {
       return this.getAllDevices();
    }

    @Override
    public boolean removeDevice() {
        return this.device == null;
    }
}
