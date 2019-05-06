public class Item implements Comparable<Item> {
    private double w;
    private double p;
    private int ratio;

    public Item(double w, double p) {
        this.w = w;
        this.p = p;
        this.ratio = (int) (p / w);
    }

    public Item() {

    }

    public void setW(double w) {
        this.w = w;
    }

    public void setP(double p) {
        this.p = p;
    }

    public void setRatio() {
        this.ratio = (int) (p / w);
    }

    public double getW() {
        return w;
    }

    public double getP() {
        return p;
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
