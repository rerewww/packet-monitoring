package Command;

/**
 * Created by son on 2018-10-29.
 */
public interface Command {
    public String[] analyze();
    public String[] processFromPid(final String pid);
    public String[] ethernetAnalyze();
}
