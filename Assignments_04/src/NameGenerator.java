import java.util.Scanner;
public class NameGenerator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] firstNames = {"John", "James", "Matt", "Mike"},
                lastNames = {"Smith", "Jackson", "Simmons", "Morris"};

        System.out.print("How many names do you want to generate?: ");
        int nameCount = input.nextInt();

        for (int i = 0; i < nameCount; i++) {
            int fName = (int)(Math.random() * firstNames.length),
                lName = (int)(Math.random() * lastNames.length);
            System.out.println(firstNames[fName] + " " + lastNames[lName]);
        }

        input.close();
    }
}
