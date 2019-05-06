import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Item it = new Item();
        ArrayList<Item> itemHolder = new ArrayList<Item>();
        int itemSize;
        int counter = 0;
        Scanner kb = new Scanner(System.in);
        System.out.print("How many items are you inputting? ");
        itemSize = kb.nextInt();

        while(counter < itemSize){
            it = new Item();
            System.out.print("Please enter weight for item " + (counter + 1) + ": ");
            it.setW(kb.nextDouble());


            System.out.print("Please enter profit for item " + (counter + 1) + ": ");
            it.setP(kb.nextDouble());

            System.out.println();

            it.setRatio();

            itemHolder.add(it);

            counter++;
        }

        Collections.sort(itemHolder);


        double W = 16.0;
        double[] w = {2, 5, 10, 5};
        double[] p = {40, 30, 50, 10};
        String[] include = new String[4];

        System.out.println("Brute Force: ");
        Brute_Force bf = new Brute_Force(W, w, p, w.length -1);
        bf.knapsack(-1, 0.0, 0.0, include);
        bf.print();

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