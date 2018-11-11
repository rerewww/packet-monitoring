package Service;

import Network.PacketContainer;
import Pcap.JnetPcacp;
import Pcap.JnetPcapFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by son on 2018-10-28.
 */
@Service
public class NetworkService {
    private PacketContainer packetContainer;
    private JnetPcapFactory jnetPcapFactory;

    @Autowired
    public NetworkService(final PacketContainer packetContainer, final JnetPcapFactory jnetPcapFactory) {
        this.packetContainer = packetContainer;
        this.jnetPcapFactory = jnetPcapFactory;
    }

    public PacketContainer analyze() throws IOException {
        JnetPcacp jnetPcacp = jnetPcapFactory.getPcap();
        return jnetPcacp.analyze();
    }
}
