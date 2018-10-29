package Process;

import Command.Windows;
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
        Windows windows = new Windows();
        NetworkObserver networkObserver = new NetworkObserver(packetContainer, windows);

        networkObserver.detect();
        networkObserver.availabilityProcess();
        packetContainer.print();
    }
}
