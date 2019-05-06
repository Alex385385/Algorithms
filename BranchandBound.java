import java.util.PriorityQueue;

public class BranchandBound {
    private double maxProfit;
    private int counter = 0;

    public void knapsack(int n, double[] p, double[] w, double W) {
        PriorityQueue<node> pq = new PriorityQueue();
        node u = new node();
        node v = new node(0);
        Bound b = new Bound();

        maxProfit = 0;

        v.setBound(b.bound(v, n, p, w, W));
        pq.add(v);
        counter++;
        while(!pq.isEmpty()) {
            v = pq.remove();
            if(v.getBound() > maxProfit) {
                counter++;
                u.setLevel(v.getLevel() + 1);
                u.setWeight(v.getWeight() + w[u.getLevel()]);
                u.setProfit(v.getProfit() + p[u.getLevel()]);
                u.setBound(b.bound(u, n, p, w, W));

                if(u.getWeight() <= W && u.getProfit() > maxProfit) {
                    maxProfit = u.getProfit();
                }

                if(u.getBound() > maxProfit) {
                    pq.add(u);
                }

                counter++;
                u = new node(0);
                u.setLevel(v.getLevel() + 1);
                u.setWeight(v.getWeight());
                u.setProfit(v.getProfit());
                u.setBound(b.bound(u, n, p, w, W));

                if(u.getBound() > maxProfit) {
                    pq.add(u);
                }

                u = new node(0);
                u.setLevel(v.getLevel() + 1);
                u.setWeight(v.getWeight() + w[u.getLevel()]);
                u.setProfit(v.getProfit() + p[u.getLevel()]);
            }
        }
    }

    public void print() {
        System.out.println("    Max Profit: " + maxProfit);
        System.out.println("    Counter: " + counter);
    }
}
