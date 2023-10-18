package programs.filesystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Temp {
    public static void main(String[] args) {
        ArrayList<String> fileLines = new ArrayList<>();
        try (FileReader fr = new FileReader("C:\\Users\\patri\\Desktop\\TestIO.txt");
        BufferedReader br = new BufferedReader(fr)){

            String rivi = null;
            do {
                try {
                    rivi = br.readLine();
                    if (rivi != null) {
                        fileLines.add(rivi);
                        //System.out.println(rivi);
                    }
                } catch (IOException e) {
                    System.out.println("Tiedoston luku epäonnistui.");
                    System.exit(2);
                }
            } while (rivi != null);
            //System.out.println("Random line:");
            Random r = new Random();
            int arpoIndeksi = r.nextInt(0, fileLines.size() - 1);
            System.out.println(fileLines.get(arpoIndeksi));
        }
        catch(IOException e) {
            System.out.println("Tiedoston käsittely onnistui");
            System.exit(1);
        }
    }

    public static void tallennaLevylle(List ruokalaji) throws IOException {
        ObjectOutputStream objects;
        try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\patri\\Desktop\\TestOutput.op")) {
            try (ObjectOutputStream objectOutputStream = objects = new ObjectOutputStream(outputStream)) {
                objects.writeObject(ruokalaji);
            }
        }
        objects.close();
    }
}
