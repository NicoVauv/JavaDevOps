package fr.takima.demo.controllers;

import fr.takima.demo.models.Product;
import fr.takima.demo.repositories.ProductDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 */
@RequestMapping("/")
@Controller
public class ProductController {

  private final ProductDAO productDAO;

    public ProductController(ProductDAO productDAO) {
    this.productDAO = productDAO;
  }

  // Get products from home page
    @GetMapping("/home")
    public String showProducts(Model m) {
    m.addAttribute("products", productDAO.findAll());
    return "index";
  }

    // Add a product in my list
    @PostMapping("/addNewProduct")
    public String addNewProduct(@ModelAttribute Product product, RedirectAttributes attrs) {
        attrs.addFlashAttribute("message", "Your product has been added");
        productDAO.save(product);
        return "index";
    }


  /*@PostMapping("/new")
  public RedirectView createNewUser(@ModelAttribute Product user, RedirectAttributes attrs) {
    attrs.addFlashAttribute("message", "Utilisateur ajouté avec succès");
    productDAO.save(user);
    return new RedirectView("/");
  }*/

}
