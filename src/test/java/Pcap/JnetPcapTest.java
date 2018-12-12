package Pcap;

import lombok.extern.slf4j.Slf4j;
import org.jnetpcap.PcapIf;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

/**
 * Created by son on 2018-11-11.
 */
@Slf4j
public class JnetPcapTest {
    private JnetPcacp jnetPcacp;

    @Before
    public void setUp() {
        int detectLoop = 1;
        JnetPcapWindows jnetPcapWindows = new JnetPcapWindows();
        jnetPcapWindows.setDetectLoop(detectLoop);

        JnetPcapFactory jnetPcapFactory = new JnetPcapFactory();
        jnetPcapFactory.setJnetPcapWindows(jnetPcapWindows);
        jnetPcacp = jnetPcapFactory.getPcap();
    }

    @Test
    public void analyzeTest() {
        List<PcapIf> pcapIfList = jnetPcacp.getNetworkDevices();
        // pcacpIfList에서 사용 할 디바이스를 activityDevice를 호출하여 설정한다.
        // analyze 호출한다.
    }
}
