package fr.takima.demo.controllers;

import fr.takima.demo.models.*;
import fr.takima.demo.repositories.FridgeDAO;
import fr.takima.demo.repositories.ListDAO;
import fr.takima.demo.repositories.ProductDAO;
import fr.takima.demo.repositories.ProductListDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
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
    private final ProductListDAO productListDAO;


    public ProductController(ProductDAO productDAO, ListDAO listDAO, FridgeDAO fridgeDAO, ProductListDAO productListDAO) {
        this.productDAO = productDAO;
        this.listDAO = listDAO;
        this.fridgeDAO = fridgeDAO;
        this.productListDAO = productListDAO;
    }

    // Get products from home page
    @GetMapping
    public String showAll(Model m, HttpServletResponse response, @CookieValue(value = "reference", defaultValue = "null") String id_fridge) {
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
        } else {
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

    // Add a product in my list
    @PostMapping("/addList")
    public RedirectView addToTheList(@ModelAttribute Product product, RedirectAttributes attrs, @CookieValue(value = "reference", defaultValue = "null") String id_fridge) {
        attrs.addFlashAttribute("message", "Your product has been added to your list");
        MyFridge myFridge = fridgeDAO.findMyFridgeByReference(id_fridge);
        MyList myList = listDAO.findMyListByMyFridge(myFridge);

        ProductList productList = new ProductList();
        productList.setMyLists(product);
        productList.setMyProducts(myList);
        productList.setOnlist(1);

        List<ProductList> myProductList = myList.getMyProducts();
        myProductList.add(productList);
        myList.setMyProducts(myProductList);
        return new RedirectView("/dashboard");
    }

    // Release a product in my list
    @PostMapping("/releaseQuantity")
    public RedirectView releaseQuantity(@ModelAttribute Product product, RedirectAttributes attrs, @CookieValue(value = "reference", defaultValue = "null") String id_fridge) {
       attrs.addFlashAttribute("message", "Your product has been released from your list");
        MyFridge myFridge = fridgeDAO.findMyFridgeByReference(id_fridge);
        MyList myList = listDAO.findMyListByMyFridge(myFridge);

        List<ProductList> productList = myList.getMyProducts();
        for (int i = 0; i < productList.size(); i++){
            if(productList.get(i).getMyLists().getName().equals(product.getName())){
                if(productList.get(i).getOnlist() == 1){
                   productListDAO.delete(productList.get(i));
                }
                else {
                    productList.get(i).setOnlist(productList.get(i).getOnlist() - 1);
                }
            }
        }

       return new RedirectView("/dashboard");
    }

    // Release a product in my list
    @PostMapping("/addQuantity")
    public RedirectView addQuantity(@ModelAttribute Product product, RedirectAttributes attrs, @CookieValue(value = "reference", defaultValue = "null") String id_fridge) {
        attrs.addFlashAttribute("message", "Your product has been released from your list");
        MyFridge myFridge = fridgeDAO.findMyFridgeByReference(id_fridge);
        MyList myList = listDAO.findMyListByMyFridge(myFridge);

        List<ProductList> productList = myList.getMyProducts();
        for (int i = 0; i < productList.size(); i++){
           if(productList.get(i).getMyLists().getName().equals(product.getName())){
               productList.get(i).setOnlist(productList.get(i).getOnlist() + 1);
           }
        }
       return new RedirectView("/dashboard");
    }

    // Add a product list in my fridge
    @PostMapping("/addFridge")
    public RedirectView addToTheFridge(@ModelAttribute MyList myList, RedirectAttributes attrs, @CookieValue(value = "reference", defaultValue = "null") String id_fridge) {
        attrs.addFlashAttribute("message", "Your list has been added to your fridge");
        MyFridge myFridge = fridgeDAO.findMyFridgeByReference(id_fridge);
        ProductFridge productFridge = new ProductFridge();
        List<ProductFridge> myProductFridge = myFridge.getMyProducts();

        for (int i = 0; i < myList.getMyProducts().size(); i++) {
            for (int j = 0; j < myFridge.getMyProducts().size(); j++) {
                if (myList.getMyProducts().get(i).getMyLists().getName().equals(myFridge.getMyProducts().get(j).getMyFridges().getName())) {
                    productFridge.setMyProducts(myFridge);
                    productFridge.setMyFridges(myList.getMyProducts().get(i).getMyLists());
                    productFridge.setOnfridge(myList.getMyProducts().get(i).getOnlist() + myFridge.getMyProducts().get(j).getOnfridge());
                } else {
                    productFridge.setMyProducts(myFridge);
                    productFridge.setMyFridges(myList.getMyProducts().get(i).getMyLists());
                    productFridge.setOnfridge(myList.getMyProducts().get(i).getOnlist());
                    myProductFridge.add(productFridge);
                }
            }

        }
        return new RedirectView("/dashboard");
    }

}
