import java.util.ArrayList;
import java.util.Collections;

public class ChangeHistory {

    private ArrayList<Double> changeHistory;

    public ChangeHistory() {
        this.changeHistory = new ArrayList<>();
    }

    public void add(double status) {
        this.changeHistory.add(status);
    }

    public void clear() {
        this.changeHistory.clear();
    }

    public double maxValue() {
        if (this.changeHistory.isEmpty()) {
            return 0.0;
        }

        return Collections.max(this.changeHistory);
    }

    public double minValue() {
        if (this.changeHistory.isEmpty()) {
            return 0.0;
        }

        return Collections.min(this.changeHistory);
    }

    public double average() {
        if (this.changeHistory.isEmpty()) {
            return 0.0;
        }

        int count = 0;
        double total = 0.0;

        for (Double item : this.changeHistory) {
            total += item;
            count++;
        }

        return total / count;
    }

    @Override
    public String toString() {
        return this.changeHistory.toString();
    }


}
