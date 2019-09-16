package fr.takima.demo.controllers;

import fr.takima.demo.repositories.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RequestMapping("/")
@Controller

public class UserController {

    private final UserDAO UserDAO;

    public UserController(fr.takima.demo.repositories.UserDAO userDAO) {
        UserDAO = userDAO;
    }

    @GetMapping("/login")
    public String showAll(Model m) {
        m.addAttribute("users", UserDAO.findAll());
        return "index";
    }

}
