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
    String protocol;
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

    protected TcpModel tcpModel;

    public Packet(
            final String protocol,
            final String localAddress,
            final String remoteAddress,
            final int localPort,
            final int remotePort,
            final String flag,
            final int size,
            final String hexDump,
            TcpModel tcpModel
    ) {
        this.protocol = protocol;
        this.localAddress = localAddress;
        this.remoteAddress = remoteAddress;
        this.localPort = localPort;
        this.remotePort = remotePort;
        this.flag = flag;
        this.size = size;
        this.hexDump = hexDump;
        this.tcpModel = tcpModel;
    }
}
