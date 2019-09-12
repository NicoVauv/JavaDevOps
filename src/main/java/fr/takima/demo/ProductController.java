package fr.takima.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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

  @GetMapping("/home")
  public String showProducts(Model m) {
    m.addAttribute("products", productDAO.findAll());
    return "index";
  }

  @GetMapping("/myProducts")
  public String showMyProducts(Model m) {
    m.addAttribute("myProducts", productDAO.findBySelected(0));
    return "index";
  }

  @PostMapping("/myProducts")
  public String addNewProduct(Model m) {
    m.addAttribute("myProducts", productDAO.findAll());
    return "index";
  }

  @GetMapping("/new")
  public String show(Model m) {
    m.addAttribute("product", new Product());
    return "myFridge";
  }

  @PostMapping("/new")
  public RedirectView createNewUser(@ModelAttribute Product user, RedirectAttributes attrs) {
    attrs.addFlashAttribute("message", "Utilisateur ajouté avec succès");
    productDAO.save(user);
    return new RedirectView("/");
  }

}
