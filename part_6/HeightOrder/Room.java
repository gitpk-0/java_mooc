import java.util.ArrayList;

public class Room {

    private ArrayList<Person> peopleInRoom;

    public Room() {
        this.peopleInRoom = new ArrayList<>();
    }

    public void add(Person person) {
        this.peopleInRoom.add(person);
    }

    public boolean isEmpty() {
        if (this.peopleInRoom.isEmpty()) {
            return true;
        }
        return false;
    }

    public ArrayList<Person> getPersons() {
        return this.peopleInRoom;
    }

    public Person shortest() {
        if (this.peopleInRoom.isEmpty()) {
            return null;
        }

        Person shortestPerson = this.peopleInRoom.get(0);

        for (Person person: this.peopleInRoom) {
            if (person.getHeight() < shortestPerson.getHeight()) {
                shortestPerson = person;
            }
        }

        return shortestPerson;
    }

    public Person take() {
        if (this.peopleInRoom.isEmpty()) {
            return null;
        }

        Person shortestPerson = this.shortest();

        this.peopleInRoom.remove(shortestPerson);

        return shortestPerson;
    }
}

