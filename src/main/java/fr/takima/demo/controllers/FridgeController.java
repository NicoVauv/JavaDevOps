package fr.takima.demo.controllers;

import fr.takima.demo.models.MyFridge;
import fr.takima.demo.models.MyList;
import fr.takima.demo.models.User;
import fr.takima.demo.repositories.FridgeDAO;
import fr.takima.demo.repositories.ListDAO;
import fr.takima.demo.repositories.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@RequestMapping("/home")
@Controller
public class FridgeController {

  private final ListDAO listDAO;
  private final UserDAO userDAO;
  private final FridgeDAO fridgeDAO;

  public FridgeController(ListDAO listDAO, UserDAO userDAO, FridgeDAO fridgeDAO) {
    this.listDAO = listDAO;
    this.userDAO = userDAO;
    this.fridgeDAO = fridgeDAO;
  }

  // Get products from home page
  @GetMapping
  public String showMyFridges(Model m, @CookieValue(value = "id", defaultValue = "null") String id_user) {
    User user = userDAO.findById(Long.parseLong(id_user)).get();
    List <MyFridge> myFridgeLists = new ArrayList<>();
    List <MyList> myLists = user.getUsers();

    for (MyList myList : myLists) {
      MyFridge myFridge = fridgeDAO.findMyFridgeByFridgeList(myList);
      myFridgeLists.add(myFridge);
    }
    m.addAttribute("user", user);
    m.addAttribute("myFridges", myFridgeLists);
    return "acceuil";
  }

  @PostMapping("/newFridge")
  public RedirectView createNewFridge(@ModelAttribute MyFridge myFridge, RedirectAttributes attrs) {
    attrs.addFlashAttribute("message", "New Fridge Added");
    myFridge.setReference(generateFridge());
    fridgeDAO.save(myFridge);
    return new RedirectView("/home");
  }

  public String generateFridge()
  {
    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    String reference = "";
    for(int i=0;i<6;i++)
    {
      int index = (int)Math.floor(Math.random() * 62);
      reference += chars.charAt(index);
    }
    return reference;
  }

}
