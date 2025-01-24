//Creates a register and takes an amount to return a purse

import java.util.Scanner;

class Register {
        // declare denominations
        denomination hundredDollar;
        denomination fiftyDollar;
        denomination twentyDollar;
        denomination tenDollar;
        denomination fiveDollar;
        denomination oneDollar;
        denomination quarter;
        denomination dime;
        denomination nickel;
        denomination penny;

        //Initialize Denominations
        public Register() {
            hundredDollar = new denomination("Hundred-Dollar Note", 100.00, "bill", "hundred_note.png");
            fiftyDollar = new denomination("Fifty-Dollar Note", 50.00, "bill", "fifty_note.png");
            twentyDollar = new denomination("Twenty-Dollar Note", 20.00, "bill", "twenty_note.png");
            tenDollar = new denomination("Ten-Dollar Note", 10.00, "bill", "ten_note.png");
            fiveDollar = new denomination("Five-Dollar Note", 5.00, "bill", "five_note.png");
            oneDollar = new denomination("One-Dollar Note", 1.00, "bill", "one_note.png");
            quarter = new denomination("Quarter", 0.25, "coin", "quarter.png");
            dime = new denomination("Dime", 0.10, "coin", "dime.png");
            nickel = new denomination("Nickel", 0.05, "coin", "nickel.png");
            penny = new denomination("Penny", 0.01, "coin", "penny.png");
        }
        // request amount and print the money
        public static void main(String[] args) {
            Register register = new Register();

            System.out.println("Please enter the amount of money? ");
            Scanner scan = new Scanner(System.in);
            double amt = scan.nextDouble();


            Purse p = register.makeChange(amt); // this returns  the money in the purse

            System.out.println("Amount of Money in Purse\n-----------------\n" + p.toString());
            System.out.println("Total: " + p.getValue());
        }

        // find number of each denomination and returns purse
        public Purse makeChange(double amt) {
            Purse purse = new Purse();

            // adds denomination to purse and subtracts amount to find least number of bills/coins
            while (amt > 0.0001) {
                if (amt >= hundredDollar.amt()) {
                    purse.add(hundredDollar, 1);
                    amt -= hundredDollar.amt();
                } else if (amt >= fiftyDollar.amt()) {
                    purse.add(fiftyDollar, 1);
                    amt -= fiftyDollar.amt();
                } else if (amt >= twentyDollar.amt()) {
                    purse.add(twentyDollar, 1);
                    amt -= twentyDollar.amt();
                } else if (amt >= tenDollar.amt()) {
                    purse.add(tenDollar, 1);
                    amt -= tenDollar.amt();
                } else if (amt >= fiveDollar.amt()) {
                    purse.add(fiveDollar, 1);
                    amt -= fiveDollar.amt();
                } else if (amt >= oneDollar.amt()) {
                    purse.add(oneDollar, 1);
                    amt -= oneDollar.amt();
                }
                else if (amt >= quarter.amt()) {
                    purse.add(quarter, 1);
                    amt -= quarter.amt();
                }
                else if (amt >= dime.amt()) {
                    purse.add(dime, 1);
                    amt -= dime.amt();
                }
                else if (amt >= nickel.amt()) {
                    purse.add(nickel, 1);
                    amt -= nickel.amt();
                }
                else {
                    purse.add(penny, 1);
                    amt -= penny.amt();
                }
            }

            return purse;
        }


    }

