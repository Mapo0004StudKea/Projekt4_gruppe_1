package stud.kea.dk.projekt4_gruppe_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import stud.kea.dk.projekt4_gruppe_1.Model.User;
import stud.kea.dk.projekt4_gruppe_1.Repository.UserRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    @GetMapping("/createUser")
    public String visCreate() {
        return "createUser";
    }

    @PostMapping("/createUser") //Den her er taget fra muskikData, der mangler det sidste som først kan laves når databasen er i gang. Se musikdata projektet.
    public String createUser(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("date") String dateOfBirth
    ) {
        LocalDate date = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        /*User user = new User(name, lastName, email, dateOfBirth);
        UserRepository.create(user);*/
        return "redirect:/FrontPage";
    }
}

