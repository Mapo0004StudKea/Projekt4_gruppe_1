package stud.kea.dk.projekt4_gruppe_1.Model;

import java.util.List;

public class Product {
    int id;
    String productName;
    String productLink;
    String productDescription;
    double price;
    int quantity;
    int wishlist_id;

    private List<WishList> wishLists;

    public List<WishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(List<WishList> wishLists) {
        this.wishLists = wishLists;
    }

    public Product() {
    }

    public Product(int id, String productName, String productLink, String productDescription, double price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.productLink = productLink;
        this.productDescription = productDescription;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(int id, String productName, String productLink, String productDescription, double price, int quantity, int wishlist_id) {
        this.id = id;
        this.productName = productName;
        this.productLink = productLink;
        this.productDescription = productDescription;
        this.price = price;
        this.quantity = quantity;
        this.wishlist_id = wishlist_id;
    }

    public Product(String productName, String productLink, String productDescription, double price, int quantity, int wishlist_id) {
        this.productName = productName;
        this.productLink = productLink;
        this.productDescription = productDescription;
        this.price = price;
        this.quantity = quantity;
        this.wishlist_id = wishlist_id;
    }

    public int getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

