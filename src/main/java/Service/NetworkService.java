package Service;

import Network.PacketContainer;
import Pcap.JnetPcacp;
import Pcap.JnetPcapFactory;
import lombok.Getter;
import lombok.Setter;
import org.jnetpcap.PcapIf;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by son on 2018-10-28.
 */
@Service
public class NetworkService {
    private JnetPcapFactory jnetPcapFactory;

    @Autowired
    public NetworkService(final JnetPcapFactory jnetPcapFactory) {
        this.jnetPcapFactory = jnetPcapFactory;
    }

    public PacketContainer analyze() throws IOException {
        JnetPcacp jnetPcacp = jnetPcapFactory.getPcap();
        return jnetPcacp.analyze();
    }

    public JSONArray getNetworkDevices() {
        JnetPcacp jnetPcacp = jnetPcapFactory.getPcap();
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
        JnetPcacp jnetPcacp = jnetPcapFactory.getPcap();
        return jnetPcacp.activityDevice(id);
    }

    public boolean isEmptyDevice() {
        JnetPcacp jnetPcacp = jnetPcapFactory.getPcap();
        return jnetPcacp.emptyDevice();
    }
}
