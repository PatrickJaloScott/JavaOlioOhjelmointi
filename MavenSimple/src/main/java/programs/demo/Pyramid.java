package programs.demo;

public class Pyramid {
    public static void main(String[] args) {
        String star = "*", space = " ";
        for (int i = 1; i <= 7; i += 2) {
            String line = "";
            line = line.concat(space.repeat((7-i)/2));
            line = line.concat(star.repeat(i));
            System.out.println(line);
        }
    }
}
