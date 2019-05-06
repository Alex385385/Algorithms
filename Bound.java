public class Bound {
    public double bound(node u, int n, double[] p, double[] w, double W) {
        int j, k;
        double totweight;
        double result;

        if(u.getWeight() >= W) {
            return 0;
        }
        else {
            result = u.getProfit();
            j = u.getLevel() + 1;
            totweight = u.getWeight();
            while (j <= n && totweight + w[j] <= W) {
                totweight = totweight + w[j];
                result = result + p[j];
                j++;
            }
            //k = j;
            if (j <= n) {
                result = result + (W - totweight) * p[j] / w[j];
            }
            return result;
        }
    }
}
