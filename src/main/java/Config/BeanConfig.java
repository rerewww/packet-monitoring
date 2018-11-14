package Config;

import Pcap.JnetPcapFactory;
import Pcap.JnetPcapWindows;
import Network.PacketContainer;
import aop.DetectPacketAop;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by son on 2018-10-29.
 */
@Slf4j
@Configuration
public class BeanConfig {
    @Bean
    public DetectPacketAop detectPacketAop() {
        return new DetectPacketAop();
    }

    @Bean
    public PacketContainer packetContainer() {
        return new PacketContainer();
    }

    @Bean
    public JnetPcapWindows jnetPcapWindows() {
        JnetPcapWindows jnetPcapWindows = new JnetPcapWindows();
        jnetPcapWindows.setPacketContainer(this.packetContainer());
        return jnetPcapWindows;
    }

    @Bean
    public JnetPcapFactory jnetPcapFactory() {
        JnetPcapFactory jnetPcapFactory = new JnetPcapFactory();
        jnetPcapFactory.setJnetPcapWindows(this.jnetPcapWindows());
        return jnetPcapFactory;
    }
}
