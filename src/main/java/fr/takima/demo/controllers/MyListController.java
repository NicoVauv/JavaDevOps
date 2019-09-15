package fr.takima.demo.controllers;

import fr.takima.demo.models.MyList;
import fr.takima.demo.repositories.ListDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 */
@RequestMapping("/myList")
@Controller
public class MyListController {

  private final ListDAO ListDAO;

  public MyListController(ListDAO ListDAO) {
    this.ListDAO = ListDAO;
  }

  // Release a product in my list
  @PostMapping("/releaseProduct")
  public String releaseProduct(@ModelAttribute MyList mylist, RedirectAttributes attrs) {
    attrs.addFlashAttribute("message", "Your product has been released");
    if(ListDAO.findById(mylist.getId()).get().getOnlist() != 0){
      ListDAO.findById(mylist.getId()).get().setOnlist(mylist.getOnlist() - 1);
    }
    else {
      ListDAO.delete(mylist);
    }
    return "index";
  }

    // Add a product in my list
    @PostMapping("/addProduct")
    public String addNewProduct(@ModelAttribute MyList myList, RedirectAttributes attrs) {
        attrs.addFlashAttribute("message", "Your product has been added");
        ListDAO.save(myList);
        ListDAO.findById(myList.getId()).get().setOnlist(myList.getOnlist() + 1);
        return "index";
    }

  /*@PostMapping("/new")
  public RedirectView createNewUser(@ModelAttribute Product user, RedirectAttributes attrs) {
    attrs.addFlashAttribute("message", "Utilisateur ajouté avec succès");
    productDAO.save(user);
    return new RedirectView("/");
  }*/

}
