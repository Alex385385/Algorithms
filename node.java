public class node implements Comparable<node> {
     private int level;
     private double profit;
     private double weight;
     private double bound;

     public node() {
         level = 0;
         profit = 0.0;
         weight = 0.0;
         bound = 0.0;
     }

     public node(int x) {
         level = -1;
         profit = 0.0;
         weight = 0.0;
         bound = 0.0;
     }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBound() {
        return bound;
    }

    public void setBound(double bound) {
        this.bound = bound;
    }

    @Override
    public int compareTo(node o) {
         if(getBound() > o.getBound()) {
             return -1;
         }
         else if(getBound() < o.getBound()) {
             return 1;
         }
         return 0;
    }
}
