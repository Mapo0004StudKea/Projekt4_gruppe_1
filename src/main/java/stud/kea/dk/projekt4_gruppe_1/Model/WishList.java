package stud.kea.dk.projekt4_gruppe_1.Model;

import java.util.List;

public class WishList {
    int id;
    String wishListName;

    List<Product> productList;

    public WishList() {
    }

    public WishList(int id, String wishListName) {
        this.id = id;
        this.wishListName = wishListName;
    }
    public WishList(int id, String wishListName, List<Product> productList) {
        this.id = id;
        this.wishListName = wishListName;
        this.productList = productList;
    }

    public WishList(String wishListName) {
        this.wishListName = wishListName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWishListName() {
        return wishListName;
    }

    public void setWishListName(String wishListName) {
        this.wishListName = wishListName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
