package fr.takima.demo.controllers;

import fr.takima.demo.repositories.FridgeDAO;
import fr.takima.demo.repositories.ProductFridgeDAO;
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

  private final ProductFridgeDAO ProductFridgeDAO;

  public FridgeController(fr.takima.demo.repositories.ProductFridgeDAO ProductFridgeDAO) {
    this.ProductFridgeDAO = ProductFridgeDAO;
  }

  // Get products from home page
  @GetMapping("/")
  public String showMyProducts(Model m) {
    m.addAttribute("productsfridge", ProductFridgeDAO.findAll());
    return "myFridge";
  }

  /*@PostMapping("/new")
  public RedirectView createNewUser(@ModelAttribute Product user, RedirectAttributes attrs) {
    attrs.addFlashAttribute("message", "Utilisateur ajouté avec succès");
    productDAO.save(user);
    return new RedirectView("/");
  }*/

}
