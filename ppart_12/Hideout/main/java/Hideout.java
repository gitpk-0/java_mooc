public class Hideout<T> {

    private T place;

    public Hideout() {
    }

    public void putIntoHideout(T tohide) {
        this.place = tohide;
    }

    public T takeFromHideout() {
        if (place == null) {
            return null;
        }

        T temp = this.place;
        this.place = null;

        return temp;
    }

    public boolean isInHideout() {
        return this.place != null;
    }
}
