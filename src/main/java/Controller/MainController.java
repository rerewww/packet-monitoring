package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by son on 2018-10-28.
 */

@Controller
public class MainController {

    @RequestMapping("/")
    public ModelAndView main() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("name", "aaa");

        return mv;
    }
}
