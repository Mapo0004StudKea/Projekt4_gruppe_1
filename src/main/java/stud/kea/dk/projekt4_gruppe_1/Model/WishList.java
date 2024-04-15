package stud.kea.dk.projekt4_gruppe_1.Model;

import java.util.List;

public class WishList {
    int id;
    String wishListName;

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public WishList() {
    }

    public WishList(int id, String wishListName) {
        this.id = id;
        this.wishListName = wishListName;
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
}
