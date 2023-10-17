package programs.calculators;

import views.ui.UserInterface;
public class ObsoleteMeasures {
    public static final int LEIVISKA = 20, NAULA = 32;
    public static final double LUOTI = 13.28;
    public static void main(String[] args) {
        int grammat = UserInterface.promptIntegerInput("Syötä grammat");

        double luodit = grammat/LUOTI;
        int naulat = (int)luodit/NAULA;
        int leiviskat = naulat/LEIVISKA;

        naulat -= leiviskat*LEIVISKA;
        luodit -= naulat*NAULA + leiviskat*LEIVISKA*NAULA;

        System.out.printf("%d grammaa on %d leiviskä, %d naula ja %.2f luoti.", grammat, leiviskat, naulat, luodit);
    }
}
