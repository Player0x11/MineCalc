package Data.Category;

public class Recipe {
    private String item;
    private int quantity;

    public Recipe(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}