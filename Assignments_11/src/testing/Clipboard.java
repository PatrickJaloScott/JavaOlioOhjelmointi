package testing;

import java.io.*;

public class Clipboard {
    private final static String FILENAME = "testfile.csv";
    public static void main(String[] args) {
        String line;
        String[] columnNames = new String[0];
        boolean header = true;

        try (FileReader file = new FileReader(FILENAME);
             BufferedReader bufferedstream = new BufferedReader(file)) {

            do {
                line = bufferedstream.readLine();
                if (line != null) {
                    if (header) {
                        // first row of the file contains names of columns
                        columnNames = line.split(";");
                        header = false;
                    } else {
                        // just print data lines with column names
                        String[] columns = line.split(";");
                        for (int i = 0; i < columnNames.length; i++)
                            System.out.print(columnNames[i] + ": " + columns[i] + ", ");
                        System.out.println();
                    }
                }
            } while (line != null);
        } catch (FileNotFoundException fileNotFound) {
            System.err.println(fileNotFound.getLocalizedMessage());
        } catch (IOException e) {
            // Error output, will print to console even in case of output redirection
            System.err.println(e);
        }
    }
}