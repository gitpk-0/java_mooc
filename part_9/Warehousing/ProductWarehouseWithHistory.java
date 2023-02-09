
public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory changeLog;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.changeLog = new ChangeHistory();
        this.addToWarehouse(initialBalance);
    }

    public String history() {
        return this.changeLog.toString();
    }

    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        changeLog.add(this.getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        double received = super.takeFromWarehouse(amount);
        changeLog.add(getBalance());
        return received;
    }

    public void printAnalysis() {
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.history());
        System.out.println("Largest amount of product: " + this.changeLog.maxValue());
        System.out.println("Smallest amount of product: " + this.changeLog.minValue());
        System.out.println("Average: " + this.changeLog.average());
    }

}
