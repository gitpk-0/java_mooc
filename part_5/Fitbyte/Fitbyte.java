public class Fitbyte {

    private int age;
    private int restHeartRate;

    public Fitbyte(int age, int restHeartRate) {
        this.age = age;
        this.restHeartRate = restHeartRate;
    }

    public double targetHeartRate(double percentageOfMaximum) {
        double maxHeartRate = 206.3 - (0.711 * this.age);
        return (maxHeartRate - restHeartRate) * (percentageOfMaximum) + restHeartRate;
    }
}
