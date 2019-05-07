import java.util.ArrayList;

public class Bound {

    public double bound(node u, int n, ArrayList<Item> holder, double W) {
        int j;
        double totWeight;
        double result;

        if(u.getWeight() >= W) {
            return 0;
        }
        else {
            result = u.getProfit();
            j = u.getLevel() + 1;
            totWeight = u.getWeight();
            while (j <= n && totWeight + (holder.get(j).getWeight()) <= W) {
                totWeight = totWeight + (holder.get(j).getWeight());
                result = result + (holder.get(j).getProfit());
                j++;
            }
            if(j <= n) {
                result = result + (W - totWeight) * holder.get(j).getProfit() / holder.get(j).getWeight();
            }
            return result;
        }
    }
}
