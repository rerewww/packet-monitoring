package Controller;

import Network.PacketContainer;
import Network.model.AjaxModel;
import Service.NetworkService;
import Service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by son on 2018-10-28.
 */

@RestController
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
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("systemInfos", systemService.getSystemOsName());
        return modelAndView;
    }

    @RequestMapping("/detecting")
    public AjaxModel detect() throws IOException {
        networkService.analyze();
        String result = packetContainer.buildJsonArray().toString();
        networkService.clearPackets();
        return new AjaxModel(true, "success", result, null);
    }

    @RequestMapping("viewDevices")
    public ModelAndView viewDevices() {
        ModelAndView modelAndView = new ModelAndView("devices");
        modelAndView.addObject("devices", networkService.getNetworkDevices());
        return modelAndView;
    }

    @RequestMapping("/selectDevice")
    public boolean selectDevice(@RequestParam(value = "id") final String id) {
        return networkService.activityDevice(id);
    }

    @RequestMapping("checkDevice")
    public AjaxModel checkDevice() {
        boolean result = networkService.checkDevice();
        return new AjaxModel(true, "success", result, null);
    }
}
