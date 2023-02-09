
public class Main {

    public static void main(String[] args) {
        // Test your class here

//        Room room = new Room();
//        System.out.println("Empty room? " + room.isEmpty());
//        room.add(new Person("Lea", 183));
//        room.add(new Person("Kenya", 182));
//        room.add(new Person("Auli", 186));
//        room.add(new Person("Nina", 172));
//        room.add(new Person("Terhi", 185));
//        System.out.println("Empty room? " + room.isEmpty());
//
//        System.out.println("");
//        for (Person person : room.getPersons()) {
//            System.out.println(person);
//        }


//        Room room = new Room();
//        System.out.println("Shortest: " + room.shortest());
//        System.out.println("Empty room? " + room.isEmpty());
//        room.add(new Person("Lea", 183));
//        room.add(new Person("Kenya", 182));
//        room.add(new Person("Auli", 186));
//        room.add(new Person("Nina", 172));
//        room.add(new Person("Terhi", 185));
//        System.out.println("Empty room? " + room.isEmpty());
//
//        System.out.println("");
//        for (Person person : room.getPersons()) {
//            System.out.println(person);
//        }
//
//        System.out.println();
//        System.out.println("Shortest: " + room.shortest());
//        System.out.println("");
//        for (Person person : room.getPersons()) {
//            System.out.println(person);
//        }

//        Room room = new Room();
//        room.add(new Person("Lea", 183));
//        room.add(new Person("Kenya", 182));
//        room.add(new Person("Auli", 186));
//        room.add(new Person("Nina", 172));
//        room.add(new Person("Terhi", 185));
//
//        System.out.println("");
//        for (Person person : room.getPersons()) {
//            System.out.println(person);
//        }
//
//        System.out.println();
//        System.out.println("Shortest: " + room.take());
//        System.out.println("");
//        for (Person person : room.getPersons()) {
//            System.out.println(person);
//        }

//        Room room = new Room();
//        room.add(new Person("Lea", 183));
//        room.add(new Person("Auli", 186));
//        room.add(new Person("Kenya", 182));
//        room.add(new Person("Terhi", 185));
//        room.add(new Person("Nina", 172));
//
//        while (!room.isEmpty()) {
//            System.out.println(room.take());
//        }


        Room r = new Room();
        Person first = new Person("first", 62);
        Person second = new Person("second", 59);
        Person third = new Person("third", 104);
        Person fourth = new Person("fourth", 61);

        r.add(first);
        r.add(second);
        r.add(third);
        r.add(fourth);

        while(!r.isEmpty()) {
            System.out.println(r.take());
        }

        
    }
}
