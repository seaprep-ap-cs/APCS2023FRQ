package q4;

public class Candy {
    private String flavor;
    public String getFlavor() {
        return this.flavor;
    }

    public Candy(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return flavor;
    }
}
