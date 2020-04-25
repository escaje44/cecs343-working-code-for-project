import java.util.Comparator;

public class CompareQuantity implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        if (p1.getQuantity() < p2.getQuantity())
            return -1;
        else if (p1.getQuantity() > p2.getQuantity())
            return 1;
        else
            return 0;
    }
}