package Command;

/**
 * Created by son on 2018-10-29.
 */
public class Windows implements Command {
    private String cmdExe = "cmd.exe";
    private String prefix = "/c";
    private String cmd = "netstat";

    @Override
    public String[] analyze() {
        String option = "-no";
        return new String[] { cmdExe, prefix, cmd, option };
    }

    @Override
    public String[] processFromPid(final String pid) {
        String option = String.format("tasklist | findstr /c:\"%s\"", pid);
        return new String[] { cmdExe, prefix, option };
    }

    @Override
    public String[] ethernetAnalyze() {
        String option = "-e";
        return new String[] { cmdExe, prefix, cmd, option };
    }
}
