package fr.takima.demo.controllers;

import fr.takima.demo.models.Fridge;
import fr.takima.demo.models.List;
import fr.takima.demo.models.Product;
import fr.takima.demo.repositories.ListDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 */
@RequestMapping("/")
@Controller
public class ListController {

  private final ListDAO listDAO;

    public ListController(ListDAO listDAO) {
    this.listDAO = listDAO;
  }

    @GetMapping("/myList")
    public String showMyList(Model m) {
        m.addAttribute("myList", listDAO.findAll());
        return "index";
    }

    // Add a product in my list
    @PostMapping("/myList")
    public String addProduct(@ModelAttribute List list, RedirectAttributes attrs) {
        attrs.addFlashAttribute("message", "Your product has been added");
        listDAO.save(list);
        return "index";
    }

    // Release a product in my list
    @PostMapping("/myList")
    public String releaseProduct(@ModelAttribute List list, RedirectAttributes attrs) {
        attrs.addFlashAttribute("message", "Your product has been added");
        if(listDAO.findById(list.getId()).get().getQuantity() != 0){
            listDAO.findById(list.getId()).get().setQuantity(list.getQuantity() - 1);
        }
        else {
            listDAO.delete(list);
        }
        return "index";
    }

}
