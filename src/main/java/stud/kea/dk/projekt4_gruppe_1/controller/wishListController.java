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
public class wishListController {

    @Autowired
    public WishListRepository wishListRepository;

    @Autowired
    public ProductRepository productRepository;

    @GetMapping("/wishListSide")
    public String wishListSide(Model model){
        List<WishList> wishLists = wishListRepository.getWishList();
        model.addAttribute("wishlist", wishLists);
        System.out.println(wishLists);
        return "wishListSide";
    }
    @PostMapping("/wishListSide")
    public String seeWishList(@RequestParam("id") int id){
    wishListRepository.getWishlistByid(id);
    return "redirect:productPage";// vi skal bruge et bestemt link her!
    }
    @GetMapping("/makeWishList")
    public String makeWishList(){
        return "makeWishList";
    }

    @PostMapping("/makeWishList")
    public String newWishList(@RequestParam("wishListName") String name){
        WishList wishList = new WishList(name);
        wishListRepository.createWishlist(wishList);
        return "redirect:wishListSide";
    }

    @GetMapping("/wishlist/{id}")
    public String showTest(
            @PathVariable("id") int ListeId,
            Model model
    ) {
        //1. hent wishlist med listeid og tilføj model attribute.
        WishList wishList = wishListRepository.getWishlistByid(ListeId);
        model.addAttribute("wishlist", wishList);
        //2. hent alle produkter med wishlist = listeid, tilføj til model attribute (skal være en collection),
        List<Product> productList = productRepository.getProductListBySpecifiedId(ListeId);
        model.addAttribute("products", productList);
        return "newProductPage";
    }
}
