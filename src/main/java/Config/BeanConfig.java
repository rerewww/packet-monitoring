package Config;

import Pcap.JnetPcapFactory;
import Pcap.JnetPcapWindows;
import Network.PacketContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by son on 2018-10-29.
 */
@Configuration
public class BeanConfig {
    @Bean()
    public PacketContainer packetContainer() {
        System.out.println("Created Bean packetContainer");
        return new PacketContainer();
    }

    @Bean
    public JnetPcapWindows jnetPcapWindows() {
        System.out.println("Created Bean JnetPcapWindows");
        JnetPcapWindows jnetPcapWindows = new JnetPcapWindows();
        jnetPcapWindows.setPacketContainer(this.packetContainer());
        return jnetPcapWindows;
    }

    @Bean()
    public JnetPcapFactory jnetPcapFactory() {
        JnetPcapFactory jnetPcapFactory = new JnetPcapFactory();
        jnetPcapFactory.setJnetPcapWindows(this.jnetPcapWindows());
        System.out.println("Created Bean jnetPcapFactory");
        return jnetPcapFactory;
    }
}
