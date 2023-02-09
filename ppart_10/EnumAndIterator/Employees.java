import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Employees {

    private ArrayList<Person> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        this.employees.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        peopleToAdd.stream().forEach(person -> this.employees.add(person));
    }

    public void print() {
        Iterator<Person> allPersons = this.employees.iterator();

        while (allPersons.hasNext()) {
            System.out.println(allPersons.next());
        }
        // or // employees.stream().forEach(person -> System.out.println(person));
    }

    public void print(Education education) {
        Iterator<Person> personByEdu = this.employees.iterator();

        while (personByEdu.hasNext()) {
            Person current = personByEdu.next();
            if (current.getEducation().equals(education)) {
                System.out.println(current);
            }
        }
        // or
        // employees.stream()
        //         .filter(person -> person.getEducation().equals(education))
        //         .forEach(person -> System.out.println(person));
    }

    public void fire(Education education) {
        Iterator<Person> personByEdu = this.employees.iterator();

        while (personByEdu.hasNext()) {
            Person current = personByEdu.next();
            if (current.getEducation().equals(education)) {
                personByEdu.remove();
            }
        }
    }




}
