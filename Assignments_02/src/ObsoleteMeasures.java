import java.util.Scanner;
public class ObsoleteMeasures {
    public static final int LEIVISKA = 20, NAULA = 32;
    public static final double LUOTI = 13.28;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Syötä grammat: ");
        int grammat = input.nextInt();

        double luodit = grammat/LUOTI;
        int naulat = (int)luodit/NAULA;
        int leiviskat = naulat/LEIVISKA;

        naulat -= leiviskat*LEIVISKA;
        luodit -= naulat*NAULA + leiviskat*LEIVISKA*NAULA;

        System.out.printf("%d grammaa on %d leiviskä, %d naula ja %.2f luoti.", grammat, leiviskat, naulat, luodit);
        input.close();
    }
}
