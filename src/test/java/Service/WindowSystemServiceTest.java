package Service;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by son on 2018-11-12.
 */
public class WindowSystemServiceTest {
    WindowSystemService windowSystemService = new WindowSystemService();

    @Test
    public void getSystemOsNameTest() {
        assertThat(windowSystemService.getSystemOsName().contains("Windows") || windowSystemService.getSystemOsName().contains("Linux"), is(true));
    }

    @Test
    public void getProcessNameFromPortTest() throws IOException {
        System.out.println(windowSystemService.getProcessIdFromPort(12000));
    }

    @Test
    public void getProcessNameFromPidTest() throws IOException {
        System.out.println(windowSystemService.getProcessNameFromPid("5868"));
    }

    @Test
    public void getCpuAmountTest() {
        System.out.println(windowSystemService.getCpuAmount());
    }
}
