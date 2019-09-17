package fr.takima.demo.controllers;

import fr.takima.demo.models.MyList;
import fr.takima.demo.repositories.FridgeDAO;
import fr.takima.demo.repositories.ListDAO;
import fr.takima.demo.repositories.ProductDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 */
@RequestMapping("/myProducts")
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

  // Release a product in my list
  @PostMapping("/releaseProduct")
  public String releaseProduct(@ModelAttribute MyList mylist, RedirectAttributes attrs) {
    attrs.addFlashAttribute("message", "Your product has been released");
   /* if(ListDAO.findById(mylist.getId()).get().getOnlist() != 0){
      ListDAO.findById(mylist.getId()).get().setOnlist(mylist.getOnlist() - 1);
    }
    else {
      ListDAO.delete(mylist);
    }*/
    return "index";
  }

  // Add a product in my list
  @PostMapping("/addProduct")
  public String addNewProduct(@ModelAttribute MyList myList, RedirectAttributes attrs) {
    attrs.addFlashAttribute("message", "Your product has been added");
    ListDAO.save(myList);
    // ListDAO.findById(myList.getId()).get().setOnlist(myList.getOnlist() + 1);
    return "index";
  }

  /*@PostMapping("/new")
  public RedirectView createNewUser(@ModelAttribute Product user, RedirectAttributes attrs) {
    attrs.addFlashAttribute("message", "Utilisateur ajouté avec succès");
    productDAO.save(user);
    return new RedirectView("/");
  }*/

}
