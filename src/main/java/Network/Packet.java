package Network;

import Status.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

/**
 * Created by son on 2018-10-28.
 */

public class Packet {
    @Getter @Setter String protocol;
    @Getter @Setter String localAddress;
    @Getter @Setter String remoteAddress;
    @Getter @Setter String status;
    @Getter @Setter String pid;
    @Getter @Setter String processName;

    boolean isProtocol() {
        return !StringUtils.isEmpty(protocol);
    }

    boolean isLocalAddress() {
        return !StringUtils.isEmpty(localAddress);
    }

    boolean isRemoteAddress() {
        return !StringUtils.isEmpty(remoteAddress);
    }

    boolean isStatus() {
        return !StringUtils.isEmpty(status);
    }

    boolean isPid() {
        return !StringUtils.isEmpty(pid);
    }

    boolean isProcessName() {
        return !StringUtils.isEmpty(processName);
    }

    String print() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("프로토콜:");
        stringBuffer.append(this.protocol);
        stringBuffer.append(" 로컬주소:");
        stringBuffer.append(this.localAddress);
        stringBuffer.append(" 원격주소:");
        stringBuffer.append(this.remoteAddress);
        stringBuffer.append(" 상태:");
        stringBuffer.append(getStatusMessage(this.status));
        stringBuffer.append(" 프로세스:");
        if (!isProcessName()) {
            stringBuffer.append("없음");
        } else {
            stringBuffer.append(this.processName);
        }

        return stringBuffer.toString();
    }

    private String getStatusMessage(final String status) {
        return Status.getMessage(status);
    }
}
