package Service;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by son on 2018-11-12.
 */
public class WindowSystemServiceTest {
    private WindowSystemService windowSystemService = new WindowSystemService();

    @Test
    public void getSystemOsNameTest() {
        assertThat(windowSystemService.getSystemOsName().contains("Windows") || windowSystemService.getSystemOsName().contains("Linux"), is(true));
    }

    @Test
    public void getProcessNameFromPortTest() throws IOException {
    }

    @Test
    public void getProcessNameFromPidTest() throws IOException {
    }

    @Test
    public void getCpuAmountTest() {
        int cpu = windowSystemService.getCpuAmount();
        assertThat(cpu > 0, is(true));
    }
}
