package Pcap;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by son on 2018-10-29.
 */

public class JnetPcapFactory {
    JnetPcapWindows jnetPcapWindows;

    @Autowired
    public void setJnetPcapWindows(final JnetPcapWindows jnetPcapWindows) {
        this.jnetPcapWindows = jnetPcapWindows;
    }

    public JnetPcacp getPcap() {
        String osName = System.getProperty("os.name");
        if (osName.contains("Windows")) {
            return this.jnetPcapWindows;
        } else {
            return null;
        }
    }
}
