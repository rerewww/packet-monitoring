package Service;

import Network.PacketContainer;
import Pcap.JnetPcacp;
import Pcap.JnetPcapFactory;
import lombok.extern.slf4j.Slf4j;
import org.jnetpcap.PcapIf;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * Created by son on 2018-10-28.
 */
@Slf4j
@Service
public class NetworkService {
    private JnetPcacp jnetPcacp;
    private Map<String, Boolean> deviceList = new HashMap<>();

    @Autowired
    public NetworkService(final JnetPcapFactory jnetPcapFactory) {
        this.jnetPcacp = jnetPcapFactory.getPcap();
        List<PcapIf> pcapIfs = jnetPcacp.getNetworkDevices();

        for (PcapIf pcapIf : pcapIfs) {
            deviceList.put(pcapIf.getName(), false);
        }
    }

    public PacketContainer analyze() throws IOException {
        return jnetPcacp.analyze(new PacketContainer());
    }

    public JSONArray getNetworkDevices() {
        List<PcapIf> devices = jnetPcacp.getNetworkDevices();

        JSONArray jsonArray = new JSONArray();
        for (PcapIf device : devices) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", device.getDescription());
            jsonObject.put("id", device.getName());
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }

    public boolean activityDevice(final String id) {
        if (!jnetPcacp.activityDevice(id)) {
            return false;
        }
        deviceList.put(id, true);
        return true;
    }

    public String getActiveDevice() {
        String id = "";
        for (Map.Entry<String, Boolean> device : deviceList.entrySet()) {
            if (!device.getValue()) {
                continue;
            }
            for (PcapIf pcapIf : jnetPcacp.getNetworkDevices()) {
                if (!pcapIf.getName().equals(device.getKey())) {
                    continue;
                }
                id = pcapIf.getDescription();
            }
        }
        return id;
    }

    public boolean checkDevice() {
        for (Map.Entry<String, Boolean> device : deviceList.entrySet()) {
            if (device.getValue()) {
                log.info("device: " + device.getKey() + " status: " + device.getValue());
                return true;
            }
        }
        return false;
    }
}
