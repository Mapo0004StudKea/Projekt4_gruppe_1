package stud.kea.dk.projekt4_gruppe_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import stud.kea.dk.projekt4_gruppe_1.Model.WishList;
import stud.kea.dk.projekt4_gruppe_1.Repository.WishListRepository;

import java.util.List;


@Controller
public class wishListController {

    @Autowired
    public WishListRepository wishListRepository;

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
    return "redirect:producPage";// vi skal bruge et bestemt link her!
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
}
