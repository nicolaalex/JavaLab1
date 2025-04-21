//  create different denominations for bills and coins.
public class DenominationFactory {

    // Creates and returns an array of all  denominations
    public Denomination[] createDenominations() {
        return new Denomination[] {
                new Denomination("Hundred-Dollar Note", 100.00, "bill", "hundred_note.png"),
                new Denomination("Fifty-Dollar Note", 50.00, "bill", "fifty_note.png"),
                new Denomination("Twenty-Dollar Note", 20.00, "bill", "twenty_note.png"),
                new Denomination("Ten-Dollar Note", 10.00, "bill", "ten_note.png"),
                new Denomination("Five-Dollar Note", 5.00, "bill", "five_note.png"),
                new Denomination("One-Dollar Note", 1.00, "bill", "one_note.png"),
                new Denomination("Quarter", 0.25, "coin", "quarter.png"),
                new Denomination("Dime", 0.10, "coin", "dime.png"),
                new Denomination("Nickel", 0.05, "coin", "nickel.png"),
                new Denomination("Penny", 0.01, "coin", "penny.png")
        };
    }
}
