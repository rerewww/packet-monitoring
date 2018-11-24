package aop;

import Service.NetworkService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by son on 2018-11-14.
 */
@Slf4j
@Aspect
public class DetectPacketAop {
    @Autowired NetworkService networkService;

    @Before("execution(* Controller.NetworkController.detect())")
    public void startDetectController() {
        networkService.clearPackets();
        log.info("[Called] Detecting request from client");
    }

    @After("execution(* Controller.NetworkController.detect())")
    public void updatePacketsDatabase() {
        log.info("[Update database] update packets to database");
    }
}
