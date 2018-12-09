package Network.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by son on 2018-11-28.
 */
@AllArgsConstructor
public class UdpModel {
    @Getter private final int source;
    @Getter private final int destination;
    @Getter private final int length;
}
