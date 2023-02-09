import java.util.ArrayList;

public class MessagingService {

    private ArrayList<Message> messages;

    public MessagingService() {
        this.messages = new ArrayList<>();
    }

    public void add(Message message) {
        String messageContent = message.getContent();
        if (messageContent.length() <= 280) {
            messages.add(message);
        }
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}
