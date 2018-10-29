package Config;

import Command.CommandFactory;
import Command.Windows;
import Network.PacketContainer;
import Process.NetworkObserver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by son on 2018-10-29.
 */
@Configuration
public class BeanConfig {
    @Bean
    public Windows windows() {
        System.out.println("Created Bean Windows");
        return new Windows();
    }

    @Bean()
    public PacketContainer packetContainer() {
        System.out.println("Created Bean packetContainer");
        return new PacketContainer();
    }

    @Bean
    public NetworkObserver networkObserver() {
        CommandFactory commandFactory = new CommandFactory();
        return new NetworkObserver(packetContainer(), commandFactory.getCommandImpl());
    }
}
