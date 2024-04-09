package stud.kea.dk.projekt4_gruppe_1.Model;

public class Product {
    int id;
    int rank;
    String name;
    String category;
    String description;
    double price;

    public Product() {
    }

    public Product(int rank, String name, String category, String description, double price) {
        this.rank = rank;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public Product(int id, int rank, String name, String category, String description, double price) {
        this.id = id;
        this.rank = rank;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
