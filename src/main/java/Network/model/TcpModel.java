package Network.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by son on 2018-11-28.
 */
@AllArgsConstructor
public class TcpModel {
    @Getter private final int source;
    @Getter private final int destination;
    @Getter private final long seqNumber;
    @Getter private final long acknowledgeNumber;
    @Getter private final int offset;
    @Getter private final int window;
    @Getter private final int urgent;
    @Getter private final String flag;
}
