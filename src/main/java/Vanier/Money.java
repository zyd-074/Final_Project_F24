package Vanier;

/**
    This class represents non-negative amounts of money.
 */
public class Money {
    // The number of dollars
    private long dollars;
    // The number of cents
    private long cents;

    /**
     Constructor
     @param amount The amount in decimal format.
     */
    public Money(double amount) {
        if (amount < 0) {
            System.out.println("Error: Negative amounts of money are not allowed.");
            System.exit(0);
        }
        else {
            long allCents = Math.round(amount * 100);
            dollars = allCents / 100;
            cents = allCents % 100;
        }
    }
    // TASK #1
    /**
     * Copy Constructor
     * @param otherMoney A copy of the value of the instance variable from the object to the new object
     */
    public Money(Money otherMoney){
        //Copy the value of the dollars and cents from the object called
        this.dollars = otherMoney.dollars;
        this.cents = otherMoney.cents;
    }
    /**
    The add method
    @param otherAmount The amount of money to add.
    @return The sum of the calling Money object
    and the parameter Money object.
     */
    public Money add(Money otherAmount) {
        Money sum = new Money(0);
        sum.cents = this.cents + otherAmount.cents;
        long carryDollars = sum.cents / 100;
        sum.cents = sum.cents % 100;
        sum.dollars = this.dollars +
                otherAmount.dollars +
                carryDollars;
        return sum;
    }
    /**
    The subtract method
    @param amount The amount of money to subtract.
    @return The difference between the calling Money
    object and the parameter Money object.
     */
    public Money subtract (Money amount) {
        Money difference = new Money(0);
        if (this.cents < amount.cents)
        {
            this.dollars = this.dollars - 1;
            this.cents = this.cents + 100;
        }
        difference.dollars = this.dollars - amount.dollars;
        difference.cents = this.cents - amount.cents;
        return difference;
    }
    /**
     The compareTo method
     @param amount The amount of money to compare against.
     @return -1 if the dollars and the cents of the
     calling object are less than the dollars and
     the cents of the parameter object.<p>
     0 if the dollars and the cents of the calling
     object are equal to the dollars and cents of
     the parameter object.<p>
     1 if the dollars and the cents of the calling
     object are more than the dollars and the
     cents of the parameter object.
     */
    public int compareTo(Money amount) {
        int value;
        if(this.dollars < amount.dollars)
            value = -1;
        else if (this.dollars > amount.dollars)
            value = 1;
        else if (this.cents < amount.cents)
            value = -1;
        else if (this.cents > amount.cents)
            value = 1;
        else
            value = 0;
        return value;
    }
// TASK #2
// Equals Method
    /**
     * The Equals Method
     * @param userMoney the object which we want to compare to the original object
     * @return true if the dollars and the cents of the calling object are the same as the ones of the parameter object.<p>
     *         false if otherwise.
     */
    public boolean equals(Money userMoney) {
        //Return true if these dollars and cents has the same value as the object we want to compare with
        return this.dollars == userMoney.dollars && this.cents == userMoney.cents;
    }
// toString method

    /**
     * The toString Method
     * @return A String in the format of "$dollars.cents"
     */
    public String toString() {
        //Check first if cents has less than 10
        String stringCents; //Define a String for cents before the check
        if (this.cents < 10){
            stringCents = "0" + this.cents;
        }
        else {
            stringCents = "" + this.cents;
        }
        //Return the String in the format of "$dollars.cents"
        return "$" + this.dollars + "." + stringCents;
    }
}