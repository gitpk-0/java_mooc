public class Counter {

    // instance variables
    private int number;

    // constructors
    public Counter(int startValue) {
        this.number = startValue;
    }

    public Counter() {
        this.number = 0;
    }

    // methods
    public int value() {
        return this.number;
    }

    public void increase() {
        this.number = this.number + 1;
    }

    public void decrease() {
        this.number = this.number - 1;
    }

    // overload methods
    public void increase(int increaseBy) {
        if (increaseBy > 0) {
            this.number = this.number + increaseBy;
        }
    }

    public void decrease(int decreaseBy) {
        if (decreaseBy > 0) {
            this.number = this.number - decreaseBy;
        }
    }
}
