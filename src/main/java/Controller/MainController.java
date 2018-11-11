package Controller;

import Network.PacketContainer;
import Service.NetworkService;
import Service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by son on 2018-10-28.
 */

@Controller
public class MainController {
    private PacketContainer packetContainer;
    private NetworkService networkService;
    private SystemService systemService;

    @Autowired
    public MainController(final PacketContainer packetContainer, final NetworkService networkService, final SystemService systemService) {
        this.packetContainer = packetContainer;
        this.networkService = networkService;
        this.systemService = systemService;
    }

    @RequestMapping("/")
    public ModelAndView analyze() throws IOException {
        networkService.analyze();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("systemInfos", systemService.getSystemOsName());
        modelAndView.addObject("totalPackets", packetContainer.buildJsonArray().toList());
        return modelAndView;
    }
}
