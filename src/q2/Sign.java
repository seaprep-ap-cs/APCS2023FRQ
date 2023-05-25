package q2;

public class Sign {
    private String message;
    private int width;

    public Sign(String message, int width) {
        this.message = message;
        this.width = width;
    }

    public int numberOfLines() {
        int lengthOfMsg = this.message.length();

        int currentNumOfLines = lengthOfMsg / this.width;

        int leftover = lengthOfMsg % this.width;

        if (leftover > 0) {
            return currentNumOfLines + 1;
        }
        return currentNumOfLines;
    }

    public String getLines() {
        if (this.message.length() == 0) {
            return null;
        }

        String result = "";
        int msgCursor = 0;
        // build the string for the number of lines that have exactly 'width' characters
        for (int line = 0; line < numberOfLines() - 1; line++) {
            String msgSlice = this.message.substring(msgCursor, msgCursor + this.width);
            result += msgSlice + ";" ;
            msgCursor += this.width;
        }

        // Get the last line and add it to the string (aka Fence post problem)
        String msgSlice = this.message.substring(msgCursor);
        result += msgSlice;

        return result;
    }

    public static void main(String[] args) {
        String msg = "ABC222DE";
        int width = 3;

        Sign sign1 = new Sign(msg, width);
        print(sign1.numberOfLines());
        print(sign1.getLines());
        print(sign1.getLines());

        msg = "ABCD";
        width = 10;
        Sign sign2 = new Sign(msg, width);
        print(sign2.numberOfLines());
        print(sign2.getLines());

        msg = "ABCDEF";
        width = 6;
        Sign sign3 = new Sign(msg, width);
        print(sign3.numberOfLines());
        print(sign3.getLines());

        msg = "";
        width = 4;
        Sign sign4 = new Sign(msg, width);
        print(sign4.numberOfLines());
        print(sign4.getLines());

        msg = "AB_CD_EF";
        width = 2;
        Sign sign5 = new Sign(msg, width);
        print(sign5.numberOfLines());
        print(sign5.getLines());

    }

    private static void print(Object o) {
        System.out.println(o);
    }


}
