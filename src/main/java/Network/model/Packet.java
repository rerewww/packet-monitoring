package Network.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by son on 2018-10-28.
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Packet {
    protected String localAddress;
    protected String remoteAddress;
    protected String flag;
    protected String pid;
    protected String processName;
    protected String hexDump;
    protected String url;
    protected int localPort;
    protected int remotePort;
    protected int size;
    protected EthernetModel ethernetModel;
    protected IpModel ipModel;
    protected TcpModel tcpModel;
    protected UdpModel udpModel;
    String protocol;

    private Packet(
            final String protocol,
            final String localAddress,
            final String remoteAddress,
            final int localPort,
            final int remotePort,
            final int size,
            final String hexDump,
            final EthernetModel ethernetModel,
            final IpModel ipModel
    ) {
        this.protocol = protocol;
        this.localAddress = localAddress;
        this.remoteAddress = remoteAddress;
        this.localPort = localPort;
        this.remotePort = remotePort;
        this.size = size;
        this.hexDump = hexDump;
        this.ethernetModel = ethernetModel;
        this.ipModel = ipModel;
    }

    public Packet(
            final String protocol,
            final String localAddress,
            final String remoteAddress,
            final int localPort,
            final int remotePort,
            final String flag,
            final int size,
            final String hexDump,
            final EthernetModel ethernetModel,
            final IpModel ipModel,
            final TcpModel tcpModel
    ) {
        this(protocol, localAddress, remoteAddress, localPort, remotePort, size, hexDump, ethernetModel, ipModel);
        this.flag = flag;
        this.tcpModel = tcpModel;
    }

    public Packet(
            final String protocol,
            final String localAddress,
            final String remoteAddress,
            final int localPort,
            final int remotePort,
            final int size,
            final String hexDump,
            final EthernetModel ethernetModel,
            final IpModel ipModel,
            final UdpModel udpModel
    ) {
        this(protocol, localAddress, remoteAddress, localPort, remotePort, size, hexDump, ethernetModel, ipModel);
        this.udpModel = udpModel;
    }
}
