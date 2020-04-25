import java.util.Comparator;

public class CompareProfit implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        if (p1.getProfitPercentage() < p2.getProfitPercentage())
            return -1;
        else if (p1.getProfitPercentage() > p2.getProfitPercentage())
            return 1;
        else
            return 0;
    }
}