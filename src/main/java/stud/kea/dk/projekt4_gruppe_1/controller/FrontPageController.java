package stud.kea.dk.projekt4_gruppe_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import stud.kea.dk.projekt4_gruppe_1.Model.User;
import stud.kea.dk.projekt4_gruppe_1.Repository.UserRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Controller
public class FrontPageController {
    @GetMapping("/login")
    public String loginPage() {
        return "Login-forside";
    }

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

    @PostMapping("/createUser")
    public String createUser(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("date") String dateOfBirth
    ) {
        // Check if the date of birth is empty or null
        if (dateOfBirth == null || dateOfBirth.isEmpty()) {
            // Handle the case where the date of birth is empty
            // You may redirect the user back to the registration page with an error message
            return "redirect:/createUser"; // Redirect to the registration page
        }

        try {
            // Parse the date string to a LocalDate object
            LocalDate date = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        /*User user = new User(name, lastName, email, dateOfBirth);
        UserRepository.create(user);*/
        } catch (DateTimeParseException e) {
            // Handle the case where the date format is invalid
            // You may redirect the user back to the registration page with an error message
            return "redirect:/createUser"; // Redirect to the registration page
        }

        return "redirect:/FrontPage";
    }

}

