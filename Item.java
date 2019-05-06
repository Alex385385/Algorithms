public class Item implements Comparable<Item> {
    private double weight;
    private double profit;
    private int ratio;

    public Item(double w, double p) {
        this.weight = w;
        this.profit = p;
        this.ratio = (int) (p / w);
    }

    public Item() {

    }

    public void setWeight(double w) {
        this.weight = w;
    }

    public void setProfit(double p) {
        this.profit = p;
    }

    public void setRatio() {
        this.ratio = (int) (profit / weight);
    }

    public double getWeight() {
        return weight;
    }

    public double getProfit() {
        return profit;
    }

    public double getRatio() {
        return ratio;
    }

    @Override
    public int compareTo(Item o) {
        if(getRatio() > o.getRatio()) {
            return -1;
        }
        else if(getRatio() < o.getRatio()) {
            return 1;
        }
        return 0;
    }
}
