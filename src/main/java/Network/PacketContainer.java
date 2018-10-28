package Network;

import Status.Status;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by son on 2018-10-28.
 */
@Log4j
public class PacketContainer {
    public List<Packet> packets = new ArrayList<>();

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

    public void print() {
        int cntListen = 0;
        int cntEstablished= 0;
        for (Packet packet : packets) {
            if (Status.LISTENING.name().equals(packet.getStatus())) {
                cntListen++;
            }

            if (Status.ESTABLISHED.name().equals(packet.getStatus())) {
                cntEstablished++;
            }
            System.out.println(packet.print());
        }
        System.out.println("[총 연결 대기 중]: " + cntListen);
        System.out.println("[총 연결 중]: " + cntEstablished);
    }
}
