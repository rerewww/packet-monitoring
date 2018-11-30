package Network.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by son on 2018-11-28.
 */
@AllArgsConstructor
public class IpModel {
    @Getter private final int version;
    @Getter private final int headerLength;
    @Getter private final int totalLength;
    @Getter private final int id;
    @Getter private final String flag;
    @Getter private final int ttl;
    @Getter private final String protocol;
    @Getter private final int checksum;
    @Getter private final String source;
    @Getter private final String destination;
}
