package Service;

import org.junit.Test;
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
