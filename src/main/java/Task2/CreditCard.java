package Task2;


public class CreditCard {
    //The balance
    private Money balance;
    //The credit limit
    private Money creditLimit;
    //The owner
    private Person owner;

    /**
     * Constructor
     * @param cardHolder The owner of the card
     * @param limit The Credit limit of the card <p>
     * Note: Balance initialized at 0 with a Money object
     */
    public CreditCard(Person cardHolder, Money limit) {
        balance = new Money(0);
        creditLimit = limit;
        owner = cardHolder;
    }

    /**
     * The getBalance Method
     * @return The balance amount for the current Credit Card as a Money object
     */
    public Money getBalance() {
        return this.balance;
    }

    /**
     * The getCreditLimit Method
     * @return The credit limit amount available for the cardholder
     */
    public Money getCreditLimit() {
        return this.creditLimit;
    }

    /**
     * The getPersonals Method
     * @return A String which tells the information about the Cardholder
     */
    public String getPersonals() {
        return this.owner.toString();
    }

    /**
     * The charge Method <p>
     * Will update the balance and the credit limit after spending the amount.
     * @param amount The amount that got spent by the Cardholder
     */
    public void charge(Money amount){
        if (this.balance.add(amount).compareTo(this.creditLimit) <= 0){
            this.balance = this.balance.add(amount);
            this.creditLimit = this.creditLimit.subtract(amount);
        }
        else{
            System.out.println("Exceeds credit limit");
        }
    }

    /**
     * The payment Method <p>
 *     Will update the balance and credit limit after repaying the amount.
     * @param amount The amount that got repaid by the Cardholder
     */
    public void payment(Money amount){
        this.balance = this.balance.subtract(amount);
        this.creditLimit = this.creditLimit.add(amount);
    }
}
