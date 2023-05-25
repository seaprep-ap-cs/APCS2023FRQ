package q4;

import java.util.Arrays;

public class BoxOfCandy {
    private Candy[][] box;

    public boolean moveCandyToFirstRow(int col) {
        if (this.box[0][col] != null) {
            return true;
        }

        // check all elements in col for a candy
        for (int row = 1; row < this.box.length; row++) {
            // apply logic from part A
            if (this.box[row][col] != null) {
                Candy c = this.box[row][col];
                this.box[0][col] = c;
                this.box[row][col] = null;
                return true;
            }
        }

        return false;
    }

    public Candy removeNextByFlavor(String flavor) {
        for (int row = this.box.length - 1; row >= 0; row--) {
            for (int col = 0; col < this.box[0].length; col++) {
                if (this.box[row][col] != null) {
                    Candy candy = this.box[row][col];
                    if (candy.getFlavor().equals(flavor)) {
                        this.box[row][col] = null;
                        return candy;
                    }
                }

            }
        }
        return null;
    }

    public BoxOfCandy(Candy[][] box) {
        this.box = box;
    }

    public static void main(String[] args) {
        // tests for Part A
        print("Showing box of candies for Part A tests..\n");
        BoxOfCandy b = createBoxOfCandyPartA();
        printBoxCandies(b.box);
        int col = 0;
        boolean res = b.moveCandyToFirstRow(col);
        print("moveCandyToFirstRow(" + col + ") returns " + res);

        col = 1;
        res = b.moveCandyToFirstRow(col);
        print("moveCandyToFirstRow(" + col + ") returns " + res);

        col = 2;
        res = b.moveCandyToFirstRow(col);
        print("moveCandyToFirstRow(" + col + ") returns " + res);
        print("");
        printBoxCandies(b.box);

        // tests for Part B
        b = createBoxOfCandyPartB();
        print("Showing box of candies for Part B tests..\n");
        printBoxCandies(b.box);
        print("");

        String flavor = "cherry";
        Candy resultCandy = b.removeNextByFlavor(flavor);
        print("removeNextByFlavor(" + flavor + ") returns " + resultCandy);
        printBoxCandies(b.box);
        print("");

        flavor = "lime";
        resultCandy = b.removeNextByFlavor(flavor);
        print("removeNextByFlavor(" + flavor + ") returns " + resultCandy);
        printBoxCandies(b.box);
        print("");

        flavor = "grape";
        resultCandy = b.removeNextByFlavor(flavor);
        print("removeNextByFlavor(" + flavor + ") returns " + resultCandy);
        printBoxCandies(b.box);
    }

    private static BoxOfCandy createBoxOfCandyPartA() {
        Candy[][] box = new Candy[4][3];
        box[0][1] = new Candy("lime");
        box[1][1] = new Candy("orange");
        box[2][2] = new Candy("cherry");
        box[3][1] = new Candy("lemon");
        box[3][2] = new Candy("grape");

        return new BoxOfCandy(box);
    }

    private static BoxOfCandy createBoxOfCandyPartB() {
        Candy[][] box = new Candy[3][5];
        box[0][0] = new Candy("lime");
        box[0][1] = new Candy("lime");
        box[0][3] = new Candy("lemon");

        box[1][0] = new Candy("orange");
        box[1][3] = new Candy("lime");
        box[1][4] = new Candy("lime");

        box[2][0] = new Candy("cherry");
        box[2][2] = new Candy("lemon");
        box[2][4] = new Candy("orange");

        return new BoxOfCandy(box);
    }

    private static void print(Object o) {
        System.out.println(o);
    }

    private static void printBoxCandies(Candy[][] array) {
        for (Candy[] x : array)
        {
            for (Candy y : x)
            {
                System.out.print(y + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
