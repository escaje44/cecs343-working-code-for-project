import java.util.ArrayList;

public class ProductView {
    private static void displayProductMenu() {
        System.out.println("Product Menu\n" +
                "1. Create Product\n" +
                "2. Display Product\n" +
                "3. Delete Product\n" +
                "4. Quit");
    }

    public static void createMenu() {
        while (true) {
            displayProductMenu();
            ProductManager projectManager = ProductManager.getProductManager();
            ArrayList<Product> productsArrayList = projectManager.getProductsList();
            int selection = CheckInput.getIntBetween(1, 4, "Please Select an option: ");
            switch (selection) {
                case 1:
                    String name = CheckInput.getString("Please enter a name:");
                    double costPrice = CheckInput.getPositiveFloat("Please enter a cost price: ");
                    double salesPrice = CheckInput.getPositiveFloat("Please enter a sales price: ");
                    if (projectManager.searchForMatchingProduct(name)) {
                        System.out.println("Product already exists.");
                    }
                    else {
                        projectManager.addProduct(name, costPrice, salesPrice);
                        System.out.println(name + " added to Products");
                    }
                    break;
                case 2:

                    for (int i = 0; i < productsArrayList.size(); i++) {
                        System.out.println(i + ". " + productsArrayList.get(i).getName());
                    }
                    System.out.println(projectManager.getProductsList().size() + ". Return");
                    int productSelection = CheckInput.getIntBetween(0, productsArrayList.size(), "Please select a product to display");
                    // Valid products will be less than productsArrayList.Size(), returning to the menu will be same value as .Size()
                    if (productSelection < productsArrayList.size()) {
                        System.out.println(productsArrayList.get(productSelection));
                    }
                    break;
                case 3:

                    for (int i = 0; i < productsArrayList.size(); i++) {
                        System.out.println(i + ". " + productsArrayList.get(i).getName());
                    }
                    System.out.println(projectManager.getProductsList().size() + ". Return");
                    int productDeleteSelection = CheckInput.getIntBetween(0, productsArrayList.size(), "Please select a product to display");
                    // Valid products will be less than productsArrayList.Size(), returning to the menu will be same value as .Size()
                    if (productDeleteSelection < productsArrayList.size()) {
                        productsArrayList.get(productDeleteSelection).delete();
                        System.out.println(productsArrayList.get(productDeleteSelection).getName() + " has been deleted");
                    }
                    break;
                case 4:
                    return;
            }
        }
    }
}
