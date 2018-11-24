package Controller;

import Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by son on 2018-11-23.
 */
@Controller
public class AdminController {
    private AdminService adminService;

    @Autowired
    AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(final HttpSession session) {
        if (!StringUtils.isEmpty(session.getAttribute("login"))) {
            session.removeAttribute("login");
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            final HttpSession session,
            @RequestParam(value = "id") final String id,
            @RequestParam(value = "password") final String password
    ) {
        if (!StringUtils.isEmpty(session.getAttribute("login"))) {
            session.removeAttribute("login");
        }

        if (adminService.login(id, password)) {
            session.setAttribute("login", id);
        }
        return "redirect:/network";
    }
}
