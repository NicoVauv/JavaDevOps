package fr.takima.demo.controllers;

import fr.takima.demo.models.User;
import fr.takima.demo.repositories.FridgeDAO;
import fr.takima.demo.repositories.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@RequestMapping("/")
@Controller

public class UserController {

    private final UserDAO UserDAO;
    private final FridgeDAO FridgeDAO;

    public UserController(UserDAO userDAO, FridgeDAO fridgeDAO) {
        this.UserDAO = userDAO;
        this.FridgeDAO = fridgeDAO;
    }

    @GetMapping("/login")
    public String getLoginPage(Model m){
        m.addAttribute("users", new User());
        return "login";
    }

    @PostMapping("/login")
    public RedirectView getConnection(@ModelAttribute User user, RedirectAttributes attrs, HttpServletResponse response){
        if(checkConnection(user)){
            attrs.addFlashAttribute("message", "Connection Successed");
            createCookie(response, user);
            return new RedirectView("/home");
        }
        else {
            attrs.addFlashAttribute("message", "Connection Failed");
            return new RedirectView("/login");
        }
    }
        private void createCookie(HttpServletResponse response, User user) {
            Cookie cookie = new Cookie("id", user.getId().toString());
            response.addCookie(cookie);
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

    @GetMapping("/signin")
    public String goToRegistrationPage(Model m){
        m.addAttribute("users", new User());
        return "signin";
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
