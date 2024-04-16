package stud.kea.dk.projekt4_gruppe_1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import stud.kea.dk.projekt4_gruppe_1.Model.Product;
import stud.kea.dk.projekt4_gruppe_1.Repository.ProductRepository;
import stud.kea.dk.projekt4_gruppe_1.Repository.WishListRepository;

@Controller
public class ProductController {

    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public WishListRepository wishListRepository;

    @GetMapping("/CreateProducts/{id}")
    public String showCreateNewProducts(
            @PathVariable("id") int wishlist_id, Model model
    ) {
        model.addAttribute("wishlistid", wishlist_id);
        return "createNewProducts";
    }

    @PostMapping("/createNewProducts")
    public String CreateNewProducts(
            @RequestParam("productName") String productName,
            @RequestParam("productLink") String productLink,
            @RequestParam("productDescription") String productDescription,
            @RequestParam("price") double price,
            @RequestParam("quantity") int quantity,
            @RequestParam("wishlist_id") int wishlist_id

    ) {
        Product product = new Product(productName, productLink, productDescription, price, quantity, wishlist_id);
        productRepository.createNewProducts(product);
        return "redirect:wishlist/"+wishlist_id;
    }

    @GetMapping("/updateProduct/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model) {
        Product product = productRepository.getProductById(id);
        model.addAttribute("product", product);
        return "updateProductForm";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(
            @RequestParam("id") int id,
            @RequestParam("productName") String productName,
            @RequestParam("productLink") String productLink,
            @RequestParam("productDescription") String productDescription,
            @RequestParam("price") double price,
            @RequestParam("quantity") int quantity
    ) {
        Product product = new Product(id, productName, productLink, productDescription, price, quantity);
        productRepository.updateProductEntry(product);
        return "redirect:wishListSide";
    }

    @GetMapping("/deleteFromProducts/{id}")
    public String deleteProductEntry(@PathVariable("id") int id, HttpServletRequest request) {
        productRepository.deleteFromProducts(id);
        String referrer = request.getHeader("referer");
        if (referrer != null && !referrer.isEmpty()) {
            return "redirect:" + referrer;
        } else {
            return "redirect:/";
        }
    }
}
