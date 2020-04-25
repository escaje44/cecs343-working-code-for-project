import java.util.ArrayList;

public class ProductManager {

    private ArrayList<Product> productsList;
    private static ProductManager singleton = null;

    public static ProductManager getProductManager(){
        if (singleton == null) {
            singleton = new ProductManager();
        }
            return singleton;
    }

    private ProductManager() {
        productsList = new ArrayList<Product>();
    }

    public boolean searchForMatchingProduct(String name) {
        for (Product p : productsList) {
            if (p.getName().equals(name))
                return true;
        }
        return false;
    }

    // use searchForMatchingProduct before using this or handle null products
    public Product returnMatchingProduct(String name) {
        ArrayList<Product> prods = getProductsList();
        for (Product p : prods) {
            if (p.getName().toLowerCase().equals(name.toLowerCase()))
                return p;
        }
        return null;
    }

    public ArrayList<Product> getProductsList() {
        ArrayList<Product> tempList = new ArrayList<Product>();
        for (Product p : productsList) {
            if (!p.isDeleted())
                tempList.add(p);
        }
        return tempList;
    }

    public void addProduct(String name, double costPrice, double salesPrice) {
        productsList.add(new Product(name, costPrice, salesPrice));
    }
}
