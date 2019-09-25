package fr.takima.demo.controllers;

import fr.takima.demo.models.*;
import fr.takima.demo.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    private final ProductFridgeDAO productFridgeDAO;
    private static String reference;


    public ProductController(ProductDAO productDAO, ListDAO listDAO, FridgeDAO fridgeDAO, ProductListDAO productListDAO, ProductFridgeDAO productFridgeDAO) {
        this.productDAO = productDAO;
        this.listDAO = listDAO;
        this.fridgeDAO = fridgeDAO;
        this.productListDAO = productListDAO;
        this.productFridgeDAO = productFridgeDAO;
    }

    // Get products from home page
    @GetMapping("/{ref}")
    public String showAll(Model m, @PathVariable(value = "ref") final String id_fridge) {
        reference = id_fridge;
        MyFridge myFridge = fridgeDAO.findMyFridgeByReference(id_fridge);
        MyList myList = listDAO.findMyListByMyFridge(myFridge);
        List<ProductList> myProductList = new ArrayList<>();
        List<ProductFridge> myProductFridge = new ArrayList<>();
        if (myList.getProducts().size() != 0) {
            m.addAttribute("myProductList", myList.getProducts());
        } else {
            m.addAttribute("myProductList", myProductList);
        }
        if (myFridge.getMyProducts().size() != 0) {
            m.addAttribute("myProductFridge", myFridge.getMyProducts());
        } else {
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
        return new RedirectView("/dashboard" + "/" + reference);
    }

    // Add a list in the fridge
    @PostMapping("/addFridge")
    public RedirectView saveMyList() {
        MyFridge myFridge = fridgeDAO.findMyFridgeByReference(reference);
        MyList myList = listDAO.findMyListByMyFridge(myFridge);

        List<ProductFridge> myProductFridge = myFridge.getMyProducts();
        ProductFridge productFridge = new ProductFridge();

        // Add product to fridge and check if it's already in
        for (int i = 0; i < myList.getProducts().size(); i++) {
                for (int j = 0; j < myProductFridge.size(); j++) {
                    if(myList.getProducts().size() != 0){
                        if (myList.getProducts().get(i).getMyLists().getName().equals(myProductFridge.get(j).getMyFridges().getName())) {
                            myProductFridge.get(j).setOnfridge(myProductFridge.get(j).getOnfridge() + myList.getProducts().get(i).getOnlist());
                            productListDAO.delete(myList.getProducts().get(i));
                            myList.getProducts().remove(myList.getProducts().get(i));
                        }
                    }
                }
            }

        // Add product to fridge if not already in the fridge
        if(myList.getProducts().size() != 0) {
            for (int i = 0; i < myList.getProducts().size(); i++) {
                productFridge.setMyProducts(myFridge);
                productFridge.setMyFridges(myList.getProducts().get(i).getMyLists());
                productFridge.setOnfridge(myList.getProducts().get(i).getOnlist());
                productFridgeDAO.save(productFridge);
                productListDAO.delete(myList.getProducts().get(i));
            }
        }

        return new RedirectView("/dashboard" + "/" + reference);
    }

    // Add a product in my list
    @PostMapping("/addList")
    public RedirectView addToTheList(RedirectAttributes attrs, HttpServletRequest request) {
        boolean checkInList = false;
        attrs.addFlashAttribute("message", "Your product has been added to your list");
        MyFridge myFridge = fridgeDAO.findMyFridgeByReference(reference);
        MyList myList = listDAO.findMyListByMyFridge(myFridge);
        Product myProduct = productDAO.findByName(request.getParameter("prod"));

        List<ProductList> myProductList = myList.getProducts();
        ProductList productList = new ProductList();

        if (myProductList.size() != 0) {
            for (int i = 0; i < myProductList.size(); i++) {
                if (myProductList.get(i).getMyLists().getName().equals(myProduct.getName())) {
                    myProductList.get(i).setOnlist(myProductList.get(i).getOnlist() + 1);
                    productListDAO.save(myProductList.get(i));
                    checkInList = true;
                }
            }
            if (!checkInList) {
                productList.setMyLists(myProduct);
                productList.setMyProducts(myList);
                productList.setOnlist(1);
                productListDAO.save(productList);
            }
        } else {
            productList.setMyLists(myProduct);
            productList.setMyProducts(myList);
            productList.setOnlist(1);
            productListDAO.save(productList);
        }
        return new RedirectView("/dashboard" + "/" + reference);
    }

    // Release a product in my list
    @PostMapping("/releaseQuantity")
    public RedirectView releaseQuantity(@ModelAttribute Product product, RedirectAttributes attrs) {
        attrs.addFlashAttribute("message", "Your product has been released from your list");
        MyFridge myFridge = fridgeDAO.findMyFridgeByReference(reference);
        MyList myList = listDAO.findMyListByMyFridge(myFridge);
        System.out.println(product.getName());
        Product myProduct = productDAO.findByName(product.getName());

        List<ProductList> productList = myList.getProducts();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getMyLists().getName().equals(myProduct.getName())) {
                if (productList.get(i).getOnlist() == 1) {
                    productListDAO.delete(productList.get(i));
                } else {
                    productList.get(i).setOnlist(productList.get(i).getOnlist() - 1);
                }
            }
        }

        return new RedirectView("/dashboard" + "/" + reference);
    }

    // Release a product in my list
    @PostMapping(value = {"/addQuantity"})
    public RedirectView addQuantity(@ModelAttribute Product product, RedirectAttributes attrs) {
        /*attrs.addFlashAttribute("message", "Your product has been released from your list");
        MyFridge myFridge = fridgeDAO.findMyFridgeByReference(reference);
        MyList myList = listDAO.findMyListByMyFridge(myFridge);
        System.out.println(product.getName());
        Product myProduct = productDAO.findByName(product.getName());

        List<ProductList> productList = myList.getProducts();
        for (int i = 0; i < productList.size(); i++){
           if(productList.get(i).getMyLists().getName().equals(product.getName())){
               productList.get(i).setOnlist(productList.get(i).getOnlist() + 1);
           }
        }*/
        return new RedirectView("/dashboard" + "/" + reference);
    }
}
