package fr.takima.demo.controllers;

import fr.takima.demo.repositories.FridgeDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@RequestMapping("/myFridge")
@Controller
public class FridgeController {

  private final FridgeDAO fridgeDAO;

  public FridgeController(FridgeDAO fridgeDAO) {
    this.fridgeDAO = fridgeDAO;
  }

  // Get products from home page
  @GetMapping
  public String showMyProducts(Model m) {
    m.addAttribute("myfridge", fridgeDAO.findAll());
    return "index";
  }

  /*@PostMapping("/new")
  public RedirectView createNewUser(@ModelAttribute Product user, RedirectAttributes attrs) {
    attrs.addFlashAttribute("message", "Utilisateur ajouté avec succès");
    productDAO.save(user);
    return new RedirectView("/");
  }*/

}
