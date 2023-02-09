
public class Main {

    public static void main(String[] args) {

        // Try out your class here

        String name1 = "pat";
        String message1 = "hello world!";

        Message first = new Message(name1, message1);

        String name2 = "rick";
        String message2 = "hello universe!";

        Message second = new Message(name2, message2);

        MessagingService mesServ = new MessagingService();

        mesServ.add(first);
        mesServ.add(second);

        System.out.println(mesServ.getMessages());

        for (Message message: mesServ.getMessages()) {
            System.out.println(message);
        }
    }
}
