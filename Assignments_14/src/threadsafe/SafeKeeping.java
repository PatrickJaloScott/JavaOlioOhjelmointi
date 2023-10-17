package threadsafe;

import java.util.ArrayList;

public class SafeKeeping {
    public static final String[] ALPHABET = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"
    };
    private ArrayList<String> letterCombinations;

    public SafeKeeping() {
        letterCombinations = new ArrayList<>();
    }

    public void addToList(int letterIndex1, int letterIndex2) {
        String combination = ALPHABET[letterIndex1] + ALPHABET[letterIndex2];
        letterCombinations.add(combination);
    }

    public synchronized int getListSize() {
        return letterCombinations.size();
    }

    public synchronized void removeFromList(int letterIndex1, int letterIndex2) {
        String combination = ALPHABET[letterIndex1] + ALPHABET[letterIndex2];
        letterCombinations.remove(combination);
    }

    public void printCombinations() {
        int x = 0;
        for (String combination : letterCombinations) {
            System.out.print(combination + " ");
            x++;
            if (x == 25) {
                System.out.println();
                x = 0;
            }
        }
    }
}
