package Controller;

import Network.model.AjaxModel;
import Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AjaxModel login(
            @RequestParam(value = "id") final String id,
            @RequestParam(value = "password") final String password
    ) {
        boolean result = adminService.login(id, password);
        return new AjaxModel(result);
    }
}
