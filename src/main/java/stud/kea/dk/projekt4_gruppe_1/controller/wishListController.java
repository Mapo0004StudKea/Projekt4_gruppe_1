package stud.kea.dk.projekt4_gruppe_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class wishListController {


    @GetMapping("/wishListSide")
    public String wishListSide(){
        return "wishListSide";
    }

    @GetMapping("/MakeWishList")
    public String makeWishList(){
        return "makeWishList";
    }

    @PostMapping("/MakeWishList")
    public String newWishList(){
        return "wishListSide";
    }
}
