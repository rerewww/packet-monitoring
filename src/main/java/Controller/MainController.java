package Controller;

import Network.PacketContainer;
import Service.NetworkService;
import org.json.JSONArray;
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
    @Autowired
    public MainController(final PacketContainer packetContainer, final NetworkService networkService) {
        this.packetContainer = packetContainer;
        this.networkService = networkService;
    }

    @RequestMapping("/")
    public ModelAndView analyze() throws IOException {
        networkService.analyze();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("totalListen", packetContainer.getTotalListen());
        modelAndView.addObject("totalConnect", packetContainer.getTotalConnect());
        modelAndView.addObject("totalPackets", packetContainer.print().toList());
        return modelAndView;
    }
}
