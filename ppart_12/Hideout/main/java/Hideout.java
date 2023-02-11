public class Hideout<T> {

    private T inHiding;

    public Hideout() {
    }

    public void putIntoHideout(T toHide) {
        this.inHiding = toHide;
    }

    public T takeFromHideout() {
        if (inHiding == null) {
            return null;
        }

        T temp = this.inHiding;
        this.inHiding = null;

        return temp;
    }

    public boolean isInHideout() {
        return this.inHiding != null;
    }
}
