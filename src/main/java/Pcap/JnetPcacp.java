package Pcap;

import Network.PacketContainer;

/**
 * Created by son on 2018-10-29.
 */
public interface JnetPcacp {
    /**
     * 실시간 패킷 분석
     * @return
     */
    public PacketContainer analyze();
}
