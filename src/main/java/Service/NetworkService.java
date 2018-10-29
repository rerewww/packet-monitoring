package Service;

import Network.PacketContainer;
import Process.NetworkObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by son on 2018-10-28.
 */
@Service
public class NetworkService {
    private NetworkObserver networkObserver;
    private PacketContainer packetContainer;

    @Autowired
    public NetworkService(final PacketContainer packetContainer, final NetworkObserver networkObserver) {
        this.packetContainer = packetContainer;
        this.networkObserver = networkObserver;
    }

    public PacketContainer analyze() throws IOException {
        networkObserver.detect();
        networkObserver.availabilityProcess();
        return packetContainer;
    }
}
