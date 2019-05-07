import java.util.ArrayList;
import java.util.Arrays;

public class Backtracking {
    private double maxProfit;
    private double W;
    private int numBest;
    private String[] bestSet;
    private int n;
    private int counter = 0;
    private ArrayList<Item> itemHolder;


    public Backtracking(double W, ArrayList<Item> holder, int n) {
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

        if(promising(i, profit, weight)) {
            include[i+1] = "yes";
            knapsack(i+1, profit+(itemHolder.get(i+1).getProfit()), weight+(itemHolder.get(i+1).getWeight()), include);
            include[i + 1] = "no";
            knapsack(i + 1, profit, weight, include);
        }
    }

    private boolean promising(int i, double profit, double weight) {
        double totWeight = 0;
        double bound = 0;
        int j;

        if(weight >= W) {
            return false;
        }
        else {
            j = i + 1;
            bound = profit;
            totWeight = weight;

            while(j <= n && totWeight + (itemHolder.get(j).getWeight()) <= W) {
                totWeight = totWeight + itemHolder.get(j).getWeight();
                bound = bound + itemHolder.get(j).getProfit();
                j++;
            }
            if(j <= n) {
                bound = bound + (W - totWeight) * itemHolder.get(j).getProfit() / itemHolder.get(j).getWeight();
            }
        }
        return bound > maxProfit;
    }

    public void print() {
        System.out.println("    Max Profit: " + maxProfit);
        System.out.println("    Nodes visited: " + counter);
        System.out.println("    Best set: " + Arrays.toString(bestSet));
    }
}