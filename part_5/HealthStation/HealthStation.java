
public class HealthStation {

    private int count = 0;

    public int weigh(Person person) {
        // return the weight of the person passed as the parameter
        count++;
        return person.getWeight();
    }

    public void feed(Person person) {
        // increase the weight of the person by one
        person.setWeight(person.getWeight() + 1);
    }


    public int weighings() {
        // how many weighings the health station has performed
        return count;
    }

}
