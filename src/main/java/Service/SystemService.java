package Service;

import org.springframework.stereotype.Service;

/**
 * Created by son on 2018-11-12.
 */
@Service
public class SystemService {
    public String getSystemOsName() {
        return System.getProperty("os.name");
    }
}