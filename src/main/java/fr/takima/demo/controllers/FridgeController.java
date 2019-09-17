package fr.takima.demo.controllers;

import fr.takima.demo.repositories.ListDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@RequestMapping("/home")
@Controller
public class FridgeController {

  private final ListDAO listDAO;

  public FridgeController(ListDAO listDAO) {
    this.listDAO = listDAO;
  }

  // Get products from home page
  @GetMapping
  public String showMyFridges(Model m) {
    return "acceuil";
  }

  /*@PostMapping("/new")
  public RedirectView createNewUser(@ModelAttribute Product user, RedirectAttributes attrs) {
    attrs.addFlashAttribute("message", "Utilisateur ajouté avec succès");
    productDAO.save(user);
    return new RedirectView("/");
  }*/

}
