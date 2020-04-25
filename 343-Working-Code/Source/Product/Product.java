import java.util.Comparator;

public class Product {

    private int quantity;
    private int amountSold;
    private double salesPrice;
    private double purchasePrice;
    private boolean isDeleted;
    private String name;

    public Product(String name, double purchasePrice, double salesPrice) {
        this.salesPrice = salesPrice;
        this.purchasePrice = purchasePrice;
        this.name = name;
        isDeleted = false;
        quantity = 0;
        amountSold = 0;
    }

    public String getName() {
        return name;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void delete() {
        isDeleted = true;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        if (salesPrice < 0)
            return;
        this.salesPrice = salesPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        if (purchasePrice < 0)
            return;
        this.purchasePrice = purchasePrice;
    }

    public int getAmountSold() {
        return amountSold;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getProfitTotal() {
        return salesPrice - purchasePrice;
    }

    public double getProfitPercentage() {
        return salesPrice - purchasePrice / salesPrice;
    }

    public double getTotalSales() {
        return amountSold * salesPrice;
    }

    public double getTotalCost() {
        return (amountSold + quantity) * salesPrice;
    }

    // Negative values are a sale, postive values increase inventory
    public void adjustQuantity(int amount) {
        if (amount < 0 && (quantity + amount) > 0) {
            quantity += amount;
            amountSold -= amount;
        }
        else if (amount > 0) {
            quantity += amount;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "quantity=" + quantity +
                ", amountSold=" + amountSold +
                ", salesPrice=" + salesPrice +
                ", purchasePrice=" + purchasePrice +
                ", isDeleted=" + isDeleted +
                ", name='" + name + '\'' +
                '}';
    }

    public String inventoryString() {
        return name + " Quantity: " + quantity;
    }

    public String invoiceString() {
        return "";
    }


}
