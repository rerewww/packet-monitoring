package Network;

import Config.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by son on 2018-10-28.
 */
public class PacketContainer {
    public List<Packet> packets = new ArrayList<>();
    @Getter @Setter private int totalListen;
    @Getter @Setter private int totalConnect;

    public void setTotalCount() {
        int cntListen = 0;
        int cntEstablished= 0;
        for (Packet packet : packets) {
            if (Status.LISTENING.name().equals(packet.getStatus())) {
                cntListen++;
            }

            if (Status.ESTABLISHED.name().equals(packet.getStatus())) {
                cntEstablished++;
            }
        }
        setTotalListen(cntListen);
        setTotalConnect(cntEstablished);
    }

    public List<Packet> getPackets() {
        return this.packets;
    }

    public void parse(final String line) {
        Packet packet = new Packet();
        if (!line.contains("TCP")) {
            return;
        }

        String[] temp = line.split(" ");
        for (int i = 0; i < temp.length; i++) {
            if (!temp[i].equals("")) {
                if(!packet.isProtocol()) {
                    packet.setProtocol(temp[i]);
                    continue;
                }

                if(!packet.isLocalAddress()) {
                    packet.setLocalAddress(temp[i]);
                    continue;
                }

                if(!packet.isRemoteAddress()) {
                    packet.setRemoteAddress(temp[i]);
                    continue;
                }

                if(!packet.isStatus()) {
                    packet.setStatus(temp[i]);
                    continue;
                }

                if(!packet.isPid()) {
                    packet.setPid(temp[i]);
                }
            }
        }
        packets.add(packet);
    }

    public StringBuffer print() {
        StringBuffer buffer = new StringBuffer();
        for (Packet packet : packets) {
            buffer.append(packet.print());
            buffer.append("<br>");
        }
        return buffer;
    }
}
