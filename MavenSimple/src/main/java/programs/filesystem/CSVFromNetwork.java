package programs.filesystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CSVFromNetwork {
    private static final String DATAURL = "https://users.metropolia.fi/~jarkkov/temploki.csv";
    public static void main(String[] args) {
        URL myURL = null;
        try {
            myURL = new URL(DATAURL);
        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
            // return;
        }
        String[] columnNames;

        BufferedReader reader = null;
        try {
            InputStream inputStream = myURL.openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            String line = reader.readLine();
            columnNames = line.split(";");
            int outdoorTemperatureIndex = 0;
            for (int i = 0; i < columnNames.length; i++) {
                if(columnNames[i].equals("Outdoor Temp (C)")) {
                    outdoorTemperatureIndex = i;
                }
            }
            float outdoorTemperatureSum = 0;
            float dataCount = 0;
            do {
                line = reader.readLine();
                if(line != null) {
                    String[] columns = line.split(";");
                    String value = columns[outdoorTemperatureIndex].replace(",", ".");
                    outdoorTemperatureSum += Float.parseFloat(value);
                    dataCount++;
                }
            } while (line != null);
            System.out.printf("\nAverage temperature was: %.2f C", (outdoorTemperatureSum/dataCount));
            reader.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing the file " + e);
            }
        }
    }
}
