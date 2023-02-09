
public class PaymentTerminal {


    private double money;  // amount of cash
    private int affordableMeals; // number of sold affordable meals
    private int heartyMeals;  // number of sold hearty meals


    public PaymentTerminal() {
        // register initially has 1000 euros of money
        this.money = 1000;
    }

    public double eatAffordably(double payment) {
        // an affordable meal costs 2.50 euros
        // increase the amount of cash by the price of an affordable mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment
        if (payment >= 2.5) {
            money = money + 2.5;
            affordableMeals = affordableMeals + 1;
            double aChange = payment - 2.5;
            return aChange;
        }
        return payment;
    }

    public double eatHeartily(double payment) {
        // a hearty meal costs 4.30 euros
        // increase the amount of cash by the price of a hearty mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment
        if (payment >= 4.3) {
            money = money + 4.3;
            heartyMeals = heartyMeals + 1;
            double hChange = payment - 4.3;
            return hChange;
        }
        return payment;
    }

    public boolean eatAffordably(PaymentCard card) {
        // an affordable meal costs 2.50 euros
        // if the payment card has enough money, the balance of the card is decreased by the price, and the method returns true
        // otherwise false is returned
        double aPrice = 2.50;
        if (card.balance() >= aPrice) {
            card.takeMoney(aPrice);
            affordableMeals = affordableMeals + 1;
            return true;
        }
        return false;
    }

    public boolean eatHeartily(PaymentCard card) {
        // a hearty meal costs 4.30 euros
        // if the payment card has enough money, the balance of the card is decreased by the price, and the method returns true
        // otherwise false is returned
        double hPrice = 4.30;
        if (card.balance() >= hPrice) {
            card.takeMoney(hPrice);
            heartyMeals = heartyMeals + 1;
            return true;
        }
        return false;
    }

    public void addMoneyToCard(PaymentCard card, double sum) {
        if (sum > 0) {
            money = money + sum;
            card.addMoney(sum);
        }
    }


    @Override
    public String toString() {
        return "money: " + money + ", number of sold affordable meals: " + affordableMeals + ", number of sold hearty meals: " + heartyMeals;
    }
}
