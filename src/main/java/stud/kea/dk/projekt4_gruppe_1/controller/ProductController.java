package stud.kea.dk.projekt4_gruppe_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import stud.kea.dk.projekt4_gruppe_1.Model.Product;
import stud.kea.dk.projekt4_gruppe_1.Model.WishList;
import stud.kea.dk.projekt4_gruppe_1.Repository.ProductRepository;
import stud.kea.dk.projekt4_gruppe_1.Repository.WishListRepository;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    public ProductRepository productRepository;
    @Autowired
   public WishListRepository wishListRepository;


    @GetMapping("/wishlist/{id}")
    public String test(Model model, @PathVariable("id") int id) {
        // Hent ønskelisten baseret på id
        WishList wishList = wishListRepository.getWishlistByid(id);

        // Hent produktlisten for ønskelisten
        List<Product> productList = wishList.getProductList();

        // Tilføj ønskelisten og produktlisten til modellen
        model.addAttribute("wishList", wishList);
        model.addAttribute("products", productList);

        // Returner navnet på viewet, som skal vises ("productPage")
        return "wishlistIDSide";
    }

    @GetMapping("/productPage/{id}")
    public String showProductList(Model model, @PathVariable("id") int id) {
        // Hent ønskelisten baseret på id
        WishList wishList = wishListRepository.getWishlistByid(id);

        // Hent produktlisten for ønskelisten
        List<Product> productList = wishList.getProductList();

        // Tilføj ønskelisten og produktlisten til modellen
        model.addAttribute("wishList", wishList);
        model.addAttribute("products", productList);

        // Returner navnet på viewet, som skal vises ("productPage")
        return "productPage";
    }

    @GetMapping("/CreateProducts")
    public String showCreateNewProducts() {
        return "createNewProducts";
    }

    @PostMapping("/createNewProducts/{id}")
    public String CreateNewProducts( @PathVariable("id")int id,
            @RequestParam("productName") String productName,
            @RequestParam("productLink") String productLink,
            @RequestParam("productDescription") String productDescription,
            @RequestParam("price") double price,
            @RequestParam("quantity") int quantity
    ) {
        Product product = new Product(productName, productLink, productDescription, price, quantity);
        productRepository.createNewProducts(product);
        return "redirect:productPage/{id}";
    }
}
