package Service;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by son on 2018-11-12.
 */
public class SystemServiceTest {
    SystemService systemService = new SystemService();
    @Test
    public void getSystemOsNameTest() {
        assertThat(systemService.getSystemOsName().contains("Windows") || systemService.getSystemOsName().contains("Linux"), is(true));
    }
}
