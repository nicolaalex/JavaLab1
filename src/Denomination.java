// represents a single denomination (e.g., Bill or Coin)

public class Denomination {
    private String name;
    private double amt;
    private String type;
    private String img;

    // Constructor to initialize denomination properties
    public Denomination(String name, double amt, String type, String img) {
        this.name = name;
        this.amt = amt;
        this.type = type;
        this.img = img;
    }

    // Getter for denomination amount
    public double amt() {
        return amt;
    }

    // Getter for denomination image
    public String img() {
        return img;
    }

    // Getter for denomination name
    public String name() {
        return name;
    }
}
