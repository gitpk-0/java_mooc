
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

    public Money plus(Money addition) {
        int eurosPlus = this.euros + addition.euros;
        int centsPlus = this.cents + addition.cents;

        Money newMoney = new Money(eurosPlus, centsPlus);
        return newMoney;
    }

    public boolean lessThan(Money compared) {
        if (this.euros == compared.euros && this.cents < compared.cents) {
            return true;
        } else if (this.euros < compared.euros) {
            return true;
        }
        return false;
    }

    public Money minus(Money decreaser) {
        int newEuros = 0;  // 10.00, 7.40 // 2.60
        int diff = this.cents - decreaser.cents; // -40
        int newCents = this.cents - decreaser.cents;
        int decOne = 0;


        if (diff < 0) {
            decOne += 1;
            newCents = 100 - (this.cents + decreaser.cents); //60
        } else {
            newCents = this.cents - decreaser.cents;
        }

        if (this.euros - decreaser.euros < 0) {
            newEuros = 0;
            newCents = 0;
        } else {
            newEuros = this.euros - decreaser.euros - decOne;
        }

        Money newMoney = new Money(newEuros, newCents);
        return newMoney;
    }

}
