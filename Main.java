import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Item it;
        ArrayList<Item> itemHolder = new ArrayList<Item>();
        Scanner kb = new Scanner(System.in);

        int itemSize;
        int counter = 0;
        double W;

        System.out.print("How many items are you inputting? ");
        itemSize = kb.nextInt();

        while(counter < itemSize){
            it = new Item();
            System.out.print("Please enter weight for item " + (counter + 1) + ": ");
            it.setWeight(kb.nextDouble());


            System.out.print("Please enter profit for item " + (counter + 1) + ": ");
            it.setProfit(kb.nextDouble());

            System.out.println();

            it.setRatio();

            itemHolder.add(it);

            counter++;
        }
        Collections.sort(itemHolder);

        System.out.print("Please enter maximum weight: ");
        W = kb.nextInt();

        double[] w = {2, 5, 10, 5};
        double[] p = {40, 30, 50, 10};
        String[] include = new String[4];

        System.out.println("Brute Force: ");
        Brute_Force temp = new Brute_Force(W, itemHolder, itemSize - 1);
        temp.knapsack(-1, 0.0, 0.0, include);
        temp.print();

        System.out.println("Backtracking: ");
        Backtracking bt = new Backtracking(W, w, p, w.length - 1);
        bt.knapsack(-1, 0.0, 0.0, include);
        bt.print();

        System.out.println("Branch and Bound: ");
        BranchandBound bg = new BranchandBound();
        bg.knapsack(3, p, w, W);
        bg.print();

        System.out.println("Done");

    }
}
/*
        int W = 8;
        int[] w = {1, 5, 3, 4};
        int[] p = {15, 10, 9, 5};
        String[] include = new String[4];

        Backtracking bg = new Backtracking(W, w, p);

        bg.knapsack(-1, 0, 0, include);

        bg.print();

        System.out.println("Done");
 */