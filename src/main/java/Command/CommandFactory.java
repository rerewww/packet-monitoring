package Command;

/**
 * Created by son on 2018-10-29.
 */
public class CommandFactory {
    public Command getCommandImpl() {
        String osName = System.getProperty("os.name");
        if (osName.contains("Windows")) {
            return new Windows();
        } else {
            return null;
        }
    }
}
