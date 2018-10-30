package Process;

import Command.Windows;
import Network.PacketContainer;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by son on 2018-10-28.
 */
public class NetworkObserverTest {
    PacketContainer packetContainer = new PacketContainer();
    Windows windows = new Windows();
    NetworkObserver networkObserver;

    @Before
    public void setUp() {
        networkObserver = new NetworkObserver(packetContainer, windows);
    }

    @Test
    public void test() throws IOException {
        networkObserver.detect();
        networkObserver.availabilityProcess();
        packetContainer.print();
    }

    @Test
    public void ethernetAnalyze() throws IOException {
        networkObserver.ethernetAnalyze();
    }
}
