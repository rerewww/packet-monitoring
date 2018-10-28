package Status;

/**
 * Created by son on 2018-10-28.
 */
public enum Status {
    LISTENING("연결을 기다리는 중"),
    ESTABLISHED("연결된 상태"),
    TIME_WAIT("연결 종료 되었지만 소켓이 열려있는 상태"),
    SYN_SENT("패킷을 보내고 연결을 요청한 상태"),
    SYN_RECV("패킷 수신 후, 응답 패킷 전송 후 클라이언트에게 패킷받기 위해 기다리는 중"),
    CLOSE_WAIT("원격 연결 요청을 받고 연결이 종료되길 기다리는 상태"),
    LAST_ACK("연결이 종료되었고, 승인을 기다리는 상태"),
    CLOSED("연결 종료"),
    FIN_WAIT_1("서버를 찾을 수 없음"),
    FIN_WAIT_2("서버에서 종료를 완료했다는 FIN을 받지 못하고 기다리는 중");

    private Status(final String message) {
        this.message = message;
    }
   private String message;

    public static String getMessage(final String status) {
        return Status.valueOf(status).message;
    }
}
