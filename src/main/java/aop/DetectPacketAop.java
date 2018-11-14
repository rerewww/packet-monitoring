package aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by son on 2018-11-14.
 */
@Slf4j
@Aspect
public class DetectPacketAop {

    @Before("execution(* Controller.MainController.detect())")
    public void startDetectController() {
        log.info("[Called] Detecting request from client");
    }

    @After("execution(* Controller.MainController.detect())")
    public void updatePacketsDatabase() {
        log.info("[Update database] update packets to database");
    }
}
