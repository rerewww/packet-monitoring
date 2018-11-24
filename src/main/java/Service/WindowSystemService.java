package Service;

import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

/**
 * Created by son on 2018-11-12.
 */
@Service
public class WindowSystemService implements SystemService {
    private static final String CMD_EXE_NAME = "cmd.exe";
    private static final String PREFIX = "/c";

    @Override
    public String getSystemOsName() {
        return System.getProperty("os.name");
    }

    @Override
    public String getProcessIdFromPort(final int port) throws IOException {
        String option = String.format("netstat -n -o | findstr :%s", port);
            StringBuilder result = this.executeCommand(this.getCommand(option));
            if (result.length() == 0) {
                return "";
            }

        String[] resultArr = StringUtils.delimitedListToStringArray(result.toString(), " ");
        return resultArr[resultArr.length - 1];
    }

    @Override
    public String getProcessNameFromPid(final String pid) throws IOException {
        String option = String.format("tasklist | findstr %s", pid);
        StringBuilder result = this.executeCommand(this.getCommand(option));
        if (result.length() == 0) {
            return "";
        }

        String[] resultArr = StringUtils.delimitedListToStringArray(result.toString(), " ");
        return resultArr[0];
    }

    @Override
    public StringBuilder executeCommand(final String[] command) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();
        StringBuilder result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "MS949"))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                result.append(line);
                line = bufferedReader.readLine();
            }
            process.waitFor();
        } catch (InterruptedException e) {
        }
        process.destroy();
        return result;
    }

    @Override
    public int getCpuAmount() {
        OperatingSystemMXBean operatingSystemMXBean = (com.sun.management.OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
        int average = 0;

        while (average <= 0.0) {
            average = (int)Math.round(operatingSystemMXBean.getSystemCpuLoad() * 100.0);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return average;
    }

    private String[] getCommand(final String cmd) {
        return new String[] { CMD_EXE_NAME, PREFIX, cmd};
    }
}