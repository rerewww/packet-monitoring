package Network;

import Network.model.Packet;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by son on 2018-10-28.
 */
public class PacketContainer {
    @Getter public List<Packet> packets = new ArrayList<>();
    @Getter @Setter private int totalListen;
    @Getter @Setter private int totalConnect;

    public void setPackets(final Packet packet) {
        this.packets.add(packet);
    }

    public synchronized void clearPackets() {
        this.packets.clear();
    }

    /**
     * Json Array형태로 만들어준다.
     * @return
     */
    public JSONArray buildJsonArray() {
        JSONArray jsonArray = new JSONArray();
        for (Packet packet : this.packets) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("protocol", packet.getProtocol());
            jsonObject.put("localAddress", packet.getLocalAddress());
            jsonObject.put("remoteAddress", packet.getRemoteAddress());
            jsonObject.put("localPort", packet.getLocalPort());
            jsonObject.put("remotePort", packet.getRemotePort());
            jsonObject.put("size", packet.getSize());
            jsonObject.put("flag", packet.getFlag());
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
}
