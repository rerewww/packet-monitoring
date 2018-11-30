package Network.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by son on 2018-11-28.
 */
@AllArgsConstructor
public class EthernetModel {
    @Getter private final String source;
    @Getter private final String destination;
}
