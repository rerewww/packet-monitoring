package Process;

import Network.PacketContainer;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by son on 2018-10-28.
 */
public class NetworkObserverTest {

    @Test
    public void test() throws IOException {
        PacketContainer packetContainer = new PacketContainer();
        NetworkObserver networkObserver = new NetworkObserver(packetContainer);

        networkObserver.detect();
        networkObserver.availabilityProcess();
        packetContainer.print();
    }
}
