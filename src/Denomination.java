public class Denomination {
    private final String name;
    private final double amount;
    private final String type;
    private final String img;

    public Denomination(String name, double amount, String type, String img) {
        this.name = name;
        this.amount = amount;
        this.type = type;
        this.img = img;
    }

    public double amt() { return amount; }
    public String name() { return name; }
    public String img() { return img; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Denomination)) return false;
        Denomination d = (Denomination) o;
        return Double.compare(d.amount, amount) == 0 && name.equals(d.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
