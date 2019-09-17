package fr.takima.demo.controllers;

import fr.takima.demo.models.User;
import fr.takima.demo.repositories.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 */
@RequestMapping("/")
@Controller

public class UserController {

    private final UserDAO UserDAO;

    public UserController(UserDAO userDAO) {
        UserDAO = userDAO;
    }

    @PostMapping("/login")
    public RedirectView getConnection(@ModelAttribute User user, RedirectAttributes attrs){
        if(checkConnection(user)){
            attrs.addFlashAttribute("message", "Connection Successed");
            return new RedirectView("/home");
        }
        else {
            attrs.addFlashAttribute("message", "Connection Failed");
            return new RedirectView("/login");
        }
    }

    private boolean checkConnection(User user) {
                    User UserConnected = UserDAO.findByMail(user.getMail());
                    if(user.getMail() != null & user.getPassword() != null){
                        if(UserConnected != null & UserConnected.getPassword().equals(user.getPassword())){
                            return true;
                        }
                        else {
                            return false;
            }

        }
        else {
            return false;
        }
    }

    @PostMapping("/signin")
    public RedirectView registration(@ModelAttribute User user, RedirectAttributes attrs) {
        User newUser = new User();
        newUser.setPseudo(user.getPseudo());
        newUser.setMail(user.getMail());
        newUser.setPassword(user.getPassword());
        UserDAO.save(newUser);
        attrs.addFlashAttribute("message", "New User added");
        return new RedirectView("/login");
    }
}
