package stud.kea.dk.projekt4_gruppe_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import stud.kea.dk.projekt4_gruppe_1.Model.WishList;
import stud.kea.dk.projekt4_gruppe_1.Repository.WishListRepository;



@Controller
public class wishListController {

    @Autowired
    public WishListRepository wishListRepository;

    @GetMapping("/wishListSide")
    public String wishListSide(){
        return "wishListSide";
    }

    @GetMapping("/MakeWishList")
    public String makeWishList(){
        return "makeWishList";
    }

    @PostMapping("/MakeWishList")
    public String newWishList(@RequestParam("wishListName") String name){
        WishList wishList = new WishList(name);
        wishListRepository.createWishlist(wishList);
        return "wishListSide";
    }
}
