package fr.takima.demo.controllers;

import fr.takima.demo.models.*;
import fr.takima.demo.repositories.FridgeDAO;
import fr.takima.demo.repositories.ListDAO;
import fr.takima.demo.repositories.ProductDAO;
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
@RequestMapping("/dashboard")
@Controller
public class ProductController {

    private final ProductDAO productDAO;
    private final ListDAO listDAO;
    private final FridgeDAO fridgeDAO;
    private final UserDAO userDAO;


    public ProductController(ProductDAO productDAO, ListDAO listDAO, FridgeDAO fridgeDAO, UserDAO userDAO) {
        this.productDAO = productDAO;
        this.listDAO = listDAO;
        this.fridgeDAO = fridgeDAO;
        this.userDAO = userDAO;
    }

    // Get products from home page
    @GetMapping
    public String showAll(Model m, @CookieValue(value = "reference", defaultValue = "null") String id_fridge) {
        MyFridge myFridge = fridgeDAO.findMyFridgeByReference(id_fridge);
        MyList myList = listDAO.findMyListByMyFridge(myFridge);

        List<ProductList> myProductList = new ArrayList<>();
        List<ProductFridge> myProductFridge = new ArrayList<>();

        if (myList.getMyProducts() != null) {
            myProductList.addAll(myList.getMyProducts());
            m.addAttribute("myProductList", myProductList);
        } else {
            myProductList.add(new ProductList());
            m.addAttribute("myProductList", myProductList);
        }
        if (myFridge.getMyProducts() != null) {
            myProductFridge.addAll(myFridge.getMyProducts());
            m.addAttribute("myProductFridge", myProductFridge);
        }
        else {
            myProductFridge.add(new ProductFridge());
            m.addAttribute("myProductFridge", myProductFridge);
        }
        // List of products
        m.addAttribute("products", productDAO.findAll());
        // An empty product to add to the product list
        m.addAttribute("product", new Product());
        return "index";
    }

    // Add a product in the product list
    @PostMapping("/add")
    public RedirectView addNewProduct(@ModelAttribute Product product, RedirectAttributes attrs) {
        attrs.addFlashAttribute("message", "Your product has been added");
        productDAO.save(product);
        return new RedirectView("/dashboard");
    }
/*
    // Add a product in my list
    @PostMapping("/addProduct")
    public RedirectView addToTheList(@ModelAttribute Product product, RedirectAttributes attrs) {
        attrs.addFlashAttribute("message", "Your product has been added to your list");
        //.save(product);
        return new RedirectView("/dashboard");
    }

    // Release a product in my list
    @PostMapping("/releaseProduct")
    public RedirectView releaseProduct(@ModelAttribute Product product, RedirectAttributes attrs) {
        attrs.addFlashAttribute("message", "Your product has been released from your list");
    if(listDAO.findById(mylist.getId()).get().getOnlist() != 0){
      listDAO.findById(mylist.getId()).get().setOnlist(mylist.getOnlist() - 1);
    }
    else {
      ListDAO.delete(mylist);
    }
        return "index";
    }
*/


}
