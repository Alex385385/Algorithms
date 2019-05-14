import java.util.ArrayList;
import java.util.Arrays;

public class Brute_Force {
    private double maxProfit;
    private double W;
    private int numBest;
    private String[] bestSet;
    private int n;
    private int counter = 0;
    private ArrayList<Item> itemHolder;

    public Brute_Force(double W, ArrayList<Item> holder,int n) {
        this.W = W;
        this.itemHolder = holder;
        this.n = n;
        bestSet = new String[n + 1];
    }

    public void knapsack(int i, double profit, double weight, String[] include) {
        if((weight <= W) && (profit > maxProfit)) {
            maxProfit = profit;
            numBest = i;
            bestSet = Arrays.copyOf(include, i + 1);
        }
        counter++;

        if(promising(i, n + 1)) {
            include[i + 1] = "yes";
            knapsack(i+1, profit+(itemHolder.get(i+1).getProfit()), weight+(itemHolder.get(i+1).getWeight()), include);
            include[i + 1] = "no";
            knapsack(i + 1, profit, weight, include);
        }
    }

    private boolean promising(int i, int n) {
        if(i == n - 1) {
            return false;
        }
        return true;
    }

    public void print() {
        System.out.println("    Max Profit: " + maxProfit);
        System.out.println("    Nodes visited: " + counter);
        System.out.println("    Best set: " + Arrays.toString(bestSet));
    }
}
