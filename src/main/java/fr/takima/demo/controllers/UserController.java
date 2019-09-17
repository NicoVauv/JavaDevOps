package fr.takima.demo.controllers;

import fr.takima.demo.repositories.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RequestMapping("/login")
@Controller

public class UserController {

    private final UserDAO UserDAO;

    public UserController(UserDAO userDAO) {
        UserDAO = userDAO;
    }

    @GetMapping
    public String showAll(Model m) {
        m.addAttribute("users", UserDAO.findAll());
        return "login";
    }

}
