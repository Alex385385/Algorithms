import java.util.Arrays;

public class Backtracking {
    private double maxProfit;
    private double W;
    private int numBest;
    private String[] bestSet;
    private int n;
    private double[] w;
    private double[] p;
    private int counter = 0;

    public Backtracking(double W, double[] w, double[] p, int n) {
        this.W = W;
        this.w = w;
        this.p = p;
        this.n = n;
        bestSet = new String[n + 1];
    }


    public void knapsack(int i, double profit, double weight, String[] include) {
        if((weight <= W) && (profit > maxProfit)) {
            maxProfit = profit;
            numBest = i;
            bestSet = Arrays.copyOf(include, include.length);
        }
        counter++;

        if(promising(i, profit, weight)) {
            include[i+1] = "yes";
            knapsack(i + 1, profit + p[i+1], weight + w[i+1], include);
            include[i + 1] = "no";
            knapsack(i + 1, profit, weight, include);
        }
    }

    private boolean promising(int i, double profit, double weight) {
        double totweight = 0;
        double bound = 0;
        int j, k;

        if(weight >= W) {
            return false;
        }
        else {
            j = i + 1;
            bound = profit;
            totweight = weight;
            while(j <= n && totweight + w[j] <= W) {
                totweight = totweight + w[j];
                bound = bound + p[j];
                j++;
            }
            //k = j;
            if(j <= n) {
                bound = bound + (W - totweight) * p[j]/w[j];
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