package Vanier;


public class CreditCard {
    //The balance
    private Money balance;
    //The credit limit
    private Money creditLimit;
    //The owner
    private Person owner;

    /**
     * Constructor
     * @param newCardHolder The owner of the card
     * @param limit The Credit limit of the card <p>
     * Balance initialized at 0 with a Money object
     */
    public CreditCard(Person newCardHolder, Money limit) {
        balance = new Money(0);
        creditLimit = limit;
        owner = newCardHolder;
    }
    public Money getBalance() {
        this.balance = new Money(balance);
        return this.balance;
    }
    public Money getCreditLimit() {
        this.creditLimit = new Money(creditLimit);
        return this.creditLimit;
    }
    public String getPersonals() {
        return this.owner.toString();
    }
    public void charge(Money amount){
        if (this.balance.add(amount).compareTo(this.creditLimit) < 0){
            this.balance = this.balance.add(amount);
        }
        else{
            System.out.println("Exceeds credit limit");
        }
    }
    public void payment(Money amount){
        this.balance = this.balance.subtract(amount);
    }
}
