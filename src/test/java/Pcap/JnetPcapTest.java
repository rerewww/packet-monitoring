package Pcap;

import Network.PacketContainer;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by son on 2018-11-11.
 */
public class JnetPcapTest {
    private JnetPcacp jnetPcacp;

    @Before
    public void setUp() {
        PacketContainer packetContainer = new PacketContainer();
        JnetPcapWindows jnetPcapWindows = new JnetPcapWindows();
        jnetPcapWindows.setPacketContainer(packetContainer);

        JnetPcapFactory jnetPcapFactory = new JnetPcapFactory();
        jnetPcapFactory.setJnetPcapWindows(jnetPcapWindows);
        jnetPcacp = jnetPcapFactory.getPcap();
    }

    @Test
    public void analyzeTest() {
        PacketContainer packetContainer = jnetPcacp.analyze();
//        System.out.println(packetContainer.buildJsonArray().toString());
        assertThat(packetContainer.getPackets().size(), is(20));
    }
}
