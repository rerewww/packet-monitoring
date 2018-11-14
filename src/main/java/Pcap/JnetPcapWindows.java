package Pcap;

import Network.Packet;
import Network.PacketContainer;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.packet.format.FormatUtils;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.tcpip.Tcp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by son on 2018-10-29.
 */
@Slf4j
public class JnetPcapWindows implements JnetPcacp {
    private PacketContainer packetContainer;
    @Setter
    private PcapIf device;

    private static final int LOOP_VAL = 20; // 크기대로 패킷을 자른다.
    private static final int SNAP_LEN = 64 * 1024; // 크기대로 패킷을 자른다.
    private static final int FLAG = Pcap.MODE_NON_PROMISCUOUS;
    private static final int TIMEOUT = 10 * 1000; // ms
    private static final StringBuilder ERROR_BUF = new StringBuilder();

    @Autowired
    public void setPacketContainer(final PacketContainer packetContainer) {
        this.packetContainer = packetContainer;
    }

    public JnetPcapWindows() {
        List<PcapIf> allDevices = new ArrayList<>();

        if (Pcap.findAllDevs(allDevices, ERROR_BUF) != Pcap.OK) {
            log.warn("[Error]: " + ERROR_BUF.toString());
        }

        for (PcapIf device : allDevices) {
            String description = (device.getDescription() != null) ? device.getDescription() : "No description available";
            log.info("[Network Device] : " + device.getName() + " " + description);
        }
        setDevice(allDevices.get(0));
    }

    /**
     * 클라이언트에서 요청받으면, LOOP_VAL만큼 패킷을 가져온다.
     * @return PacketContainer
     */
    @Override
    public PacketContainer analyze() {
        Ip4 ip4 = new Ip4();
        Tcp tcp = new Tcp();

        Pcap pcap = Pcap.openLive(device.getName(), SNAP_LEN, FLAG, TIMEOUT, ERROR_BUF);

        pcap.loop(LOOP_VAL, new PcapPacketHandler<String>() {
            public void nextPacket(final PcapPacket pcapPacket, String user) {
                if (pcapPacket.hasHeader(ip4) && pcapPacket.hasHeader(tcp)) {
                    String localAddress = FormatUtils.ip(ip4.source());
                    String remoteAddress = FormatUtils.ip(ip4.destination());
                    int localPort = tcp.source();
                    int remotePort = tcp.destination();
                    String flag = StringUtils.collectionToDelimitedString(tcp.flagsEnum(), " ");
                    int size = pcapPacket.getTotalSize();

                    packetContainer.setPackets(
                            new Packet(
                                    tcp.getName(),
                                    localAddress,
                                    remoteAddress,
                                    localPort,
                                    remotePort,
                                    flag,
                                    size
                            )
                    );
                }
            }
        }, null);
        pcap.close();
        return packetContainer;
    }
}
