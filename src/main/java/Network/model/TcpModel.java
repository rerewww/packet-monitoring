package Network.model;

import lombok.Getter;

/**
 * Created by son on 2018-11-28.
 */
public class TcpModel {
    @Getter private final int source;
    @Getter private final int destination;
    @Getter private final long seqNumber;
    @Getter private final long acknowledgeNumber;
    @Getter private final int offset;
    @Getter private final int window;
    @Getter private final int urgent;
    @Getter private final String flag;
public TcpModel(final int source, final int destination, final long seqNumber, final long acknowledgeNumber, final int offset, final int window, final int urgent, final String flag) {
        this.source = source;
        this.destination = destination;
        this.seqNumber = seqNumber;
        this.acknowledgeNumber = acknowledgeNumber;
        this.offset = offset;
        this.window = window;
        this.urgent = urgent;
        this.flag = flag;
    }
}
