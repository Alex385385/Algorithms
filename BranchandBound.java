import java.util.ArrayList;
import java.util.PriorityQueue;

public class BranchandBound {
    private double maxProfit;
    private int counter = 0;

    public void knapsack(int n, ArrayList<Item> holder, double W) {
        PriorityQueue<node> pq = new PriorityQueue<>();
        node u = new node();
        node v = new node(0);
        Bound b = new Bound();
        maxProfit = 0;
        v.setBound(b.bound(v, n, holder,W));
        pq.add(v);
        counter++;
        while(!pq.isEmpty()) {
            v = pq.remove();
            if(v.getBound() > maxProfit) {
                counter++;
                u.setLevel(v.getLevel() + 1);
                u.setWeight(v.getWeight() + holder.get(u.getLevel()).getWeight());
                u.setProfit(v.getProfit() + holder.get(u.getLevel()).getProfit());
                u.setBound(b.bound(u, n, holder, W));

                if(u.getWeight() <= W && u.getProfit() > maxProfit) {
                    maxProfit = u.getProfit();
                }

                if(u.getBound() > maxProfit) {
                    pq.add(u);
                }

                counter++;
                u = new node();
                u.setLevel(v.getLevel() + 1);
                u.setWeight(v.getWeight());
                u.setProfit(v.getProfit());
                u.setBound(b.bound(u, n, holder, W));

                if(u.getBound() > maxProfit) {
                    pq.add(u);
                }

                u = new node();
                u.setLevel(v.getLevel() + 1);
                u.setWeight(v.getWeight() + holder.get(u.getLevel()).getWeight());
                u.setProfit(v.getProfit() + holder.get(u.getLevel()).getProfit());
            }
        }
    }

    public void print() {
        System.out.println("    Max Profit: " + maxProfit);
        System.out.println("    Counter: " + counter);
    }
}
