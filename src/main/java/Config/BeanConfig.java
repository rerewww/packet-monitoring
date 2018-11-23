package Config;

import Pcap.JnetPcapFactory;
import Pcap.JnetPcapWindows;
import Network.PacketContainer;
import aop.DetectPacketAop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by son on 2018-10-29.
 */
@Slf4j
@Configuration
public class BeanConfig {
    @Value("#{serverXmlFile['admin.username']}") private String admin;
    @Value("#{serverXmlFile['admin.password']}") private String adminPassword;

    @Bean
    public ServerProperties serverProperties() {
        ServerProperties serverProperties = new ServerProperties();
        serverProperties.setAdmin(this.admin);
        serverProperties.setAdminPassword(this.adminPassword);
        return serverProperties;
    }

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
