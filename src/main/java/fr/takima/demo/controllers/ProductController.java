package fr.takima.demo.controllers;

import fr.takima.demo.repositories.FridgeDAO;
import fr.takima.demo.repositories.ListDAO;
import fr.takima.demo.repositories.ProductDAO;
import fr.takima.demo.repositories.ProductFridgeDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RequestMapping("/")
@Controller
public class ProductController {

  private final ProductDAO productDAO;
  private final ListDAO ListDAO;
  private final FridgeDAO fridgeDAO;


  public ProductController(ProductDAO productDAO, ListDAO ListDAO, FridgeDAO fridgeDAO) {
    this.productDAO = productDAO;
    this.ListDAO = ListDAO;
    this.fridgeDAO = fridgeDAO;

  }

  // Get products from home page
    @GetMapping("/home")
    public String showAll(Model m) {
    m.addAttribute("products", productDAO.findAll());
    m.addAttribute("mylist", ListDAO.findAll());
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
