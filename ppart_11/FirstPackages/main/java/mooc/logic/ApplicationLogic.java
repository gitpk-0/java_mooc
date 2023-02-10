package mooc.logic;

import mooc.ui.TextInterface;
import mooc.ui.UserInterface;

public class ApplicationLogic {

    private UserInterface ui;

    public ApplicationLogic(UserInterface ui) {
        this.ui = ui;
    }

    public void execute(int times) {
        int count = 0;
        while (count < times) {
            System.out.println("Application logic is working");
            ui.update();
            count++;
        }
    }

}
