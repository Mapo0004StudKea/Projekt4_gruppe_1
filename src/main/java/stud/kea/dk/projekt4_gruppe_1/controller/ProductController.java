package stud.kea.dk.projekt4_gruppe_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import stud.kea.dk.projekt4_gruppe_1.Model.Product;
import stud.kea.dk.projekt4_gruppe_1.Repository.ProductRepository;
import stud.kea.dk.projekt4_gruppe_1.Repository.WishListRepository;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    public ProductRepository productRepository;
    @Autowired
   public WishListRepository wishListRepository;

    @GetMapping("/productPage")
    public String showProductList(Model model, @RequestParam("id") int id) {
        wishListRepository.getWishlistByid(id);
        List<Product> productList = productRepository.getProductsList();
        model.addAttribute("products", productList);
        System.out.println(productList);
        return "productPage";
    }

    @GetMapping("/CreateProducts")
    public String showCreateNewProducts() {
        return "createNewProducts";
    }

    @PostMapping("/createNewProducts")
    public String CreateNewProducts(
            @RequestParam("productName") String productName,
            @RequestParam("productLink") String productLink,
            @RequestParam("productDescription") String productDescription,
            @RequestParam("price") double price,
            @RequestParam("quantity") int quantity
    ) {
        Product product = new Product(productName, productLink, productDescription, price, quantity);
        productRepository.createNewProducts(product);
        return "redirect:productPage";
    }
}
