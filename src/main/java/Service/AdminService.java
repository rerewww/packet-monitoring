package Service;

import Config.ServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by son on 2018-11-23.
 */
@Service
public class AdminService {
    private ServerProperties serverProperties;

    @Autowired
    AdminService (ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }

    public boolean login(final String admin, final String password) {
        return serverProperties.getAdmin().equals(admin) && serverProperties.getAdminPassword().equals(password);
    }
}