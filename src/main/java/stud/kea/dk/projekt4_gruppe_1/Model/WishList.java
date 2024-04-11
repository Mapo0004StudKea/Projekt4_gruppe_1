package stud.kea.dk.projekt4_gruppe_1.Model;

public class WishList {
    int id;
    String wishListName;

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
