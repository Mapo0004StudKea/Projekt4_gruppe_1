package stud.kea.dk.projekt4_gruppe_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import stud.kea.dk.projekt4_gruppe_1.model.User;
import stud.kea.dk.projekt4_gruppe_1.repository.UsersRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Controller
public class FrontPageController {
    @Autowired
    UsersRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "Login-forside";
    }

    @GetMapping("/")
    public String frontPageIndex() {
        return "redirect:login";
    }

    @GetMapping("/FrontPage")
    public String frontPage() {
        return "Frontpage";
    }

    @GetMapping("/createAccount")
    public String visCreate() {
        return "createAccount";
    }

    @GetMapping("loginside")
    public String visLogin() {return "loginside";}

    @PostMapping("loginside")
    public String submitLogin()
    {
        return "redirect:/FrontPage";
    }

    @PostMapping("/createAccount")
    public String createUser(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("pwd") String pwd,
            @RequestParam("date") String dateOfBirth
    ) {
        User user = new User(name, lastName, email, pwd, dateOfBirth);
        userRepository.createUser(user);
        // Check if the date of birth is empty or null
        if (dateOfBirth == null || dateOfBirth.isEmpty()) {
            // Handle the case where the date of birth is empty
            // You may redirect the user back to the registration page with an error message
            return "redirect:/createAccount"; // Redirect to the registration page
        }

        try {
            // Parse the date string to a LocalDate object
            LocalDate date = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        /*Useruser = new User(name, lastName, email, dateOfBirth);
        UserRepository.create(user);*/
        } catch (DateTimeParseException e) {
            // Handle the case where the date format is invalid
            // You may redirect the user back to the registration page with an error message
            return "redirect:/createAccount"; // Redirect to the registration page
        }

        return "redirect:/FrontPage";
    }

}