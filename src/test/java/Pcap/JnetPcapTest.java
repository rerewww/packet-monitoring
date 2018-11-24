package Pcap;

import Network.PacketContainer;
import Service.WindowSystemService;
import lombok.extern.slf4j.Slf4j;
import org.jnetpcap.PcapIf;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by son on 2018-11-11.
 */
@Slf4j
public class JnetPcapTest {
    private JnetPcacp jnetPcacp;
    private WindowSystemService windowSystemService;

    @Before
    public void setUp() {
        PacketContainer packetContainer = new PacketContainer();
        JnetPcapWindows jnetPcapWindows = new JnetPcapWindows();
        jnetPcapWindows.setPacketContainer(packetContainer);

        JnetPcapFactory jnetPcapFactory = new JnetPcapFactory();
        jnetPcapFactory.setJnetPcapWindows(jnetPcapWindows);
        jnetPcacp = jnetPcapFactory.getPcap();

        windowSystemService = new WindowSystemService();
    }

    @Test
    public void analyzeTest() {
        List<PcapIf> pcapIfList = jnetPcacp.getNetworkDevices();
        jnetPcacp.activityDevice(pcapIfList.get(4).getName());
        PacketContainer packetContainer = jnetPcacp.analyze();
//        assertThat(packetContainer.getPackets().size(), is(20));
    }

}
