package Network.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by son on 2018-10-28.
 */

@AllArgsConstructor
@Data
public class Packet {
    String protocol;
    String localAddress;
    String remoteAddress;
    String flag;
    String pid;
    String processName;
    String hexDump;
    String url;
    int localPort;
    int remotePort;
    int size;

    public Packet() {}

    public Packet(
            final String protocol,
            final String localAddress,
            final String remoteAddress,
            final int localPort,
            final int remotePort,
            final String flag,
            final int size,
            final String hexDump
    ) {
        this.protocol = protocol;
        this.localAddress = localAddress;
        this.remoteAddress = remoteAddress;
        this.localPort = localPort;
        this.remotePort = remotePort;
        this.flag = flag;
        this.size = size;
        this.hexDump = hexDump;
    }
}
