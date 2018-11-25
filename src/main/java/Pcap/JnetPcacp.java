package Pcap;

import Network.PacketContainer;
import org.jnetpcap.PcapIf;

import java.util.List;

/**
 * Created by son on 2018-10-29.
 */
public interface JnetPcacp {
    /**
     * 실시간 패킷 분석
     * @return
     */
    public PacketContainer analyze(final PacketContainer packetContainer);

    public List<PcapIf> getNetworkDevices();
    public boolean activityDevice(final String id);
    public boolean emptyDevice();
}
