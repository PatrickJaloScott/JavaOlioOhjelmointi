package programs.complex;

import model.tv.Television;
import ui.UserInterface;
import java.util.Random;

public class TelevisionViewer {
    public static void main(String[] args) {
        Television tv = new Television(10);
        System.out.print("How many days? ");
        int days = UserInterface.promptIntegerInput("How many days?"),
                i = 1;
        do {
            System.out.printf("Woke up, day %d\n", i);
            Random rand = new Random();
            int channelsToWatch = rand.nextInt(3,7);
            for (int j = 0; j < channelsToWatch; j++) {
                tv.Watch();
                tv.ChangeChannel();
            }
            System.out.println("Falling asleep");
            i++;
        } while (i <= days);
    }
}
