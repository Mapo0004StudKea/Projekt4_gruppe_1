package stud.kea.dk.projekt4_gruppe_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontPageController {
    @GetMapping("/")
    public String frontPageIndex() {
        return "redirect:FrontPage";
    }

    @GetMapping("/FrontPage")
    public String frontPage() {
        return "Frontpage";
    }
}
