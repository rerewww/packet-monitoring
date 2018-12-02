package Service;

import java.io.IOException;

/**
 * Created by son on 2018-11-24.
 */
public interface SystemService {
    public String getSystemOsName();
    public String getProcessIdFromPort(final int port) throws IOException;
    public String getProcessNameFromPid(final String pid) throws IOException;
    public StringBuilder executeCommand(final String[] command) throws IOException;
    public int getCpuAmount();
    public int getMemoryAmount();
}
