package n11.n11finalcaseahmetsaimyilmaz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String showMainMenu() {
        System.out.println("test");
        return "index";
    }
}
