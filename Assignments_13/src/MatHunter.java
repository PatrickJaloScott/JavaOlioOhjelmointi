public class MatHunter extends Thread {
    int [][] matrix;
    int iLo, iHi, jLo, jHi;
    int found;

    /* constructor gets the matrix and the indices specifying what section to examine */
    MatHunter(int [][] matrix, int iLo, int iHi, int jLo, int jHi) {
        this.matrix = matrix;
        this.iLo = iLo; this.iHi = iHi;
        this.jLo = jLo; this.jHi = jHi;

        found = 0;
    }

    /* examine a section of a 2D matrix and count the number of positive elements */
    public void run() {
        for (int i = iLo; i <= iHi; i++) {
            for (int j = jLo; j <= jHi; j++)
                if (matrix[i][j] > 0)
                    found++;

            // to give the possibility for other threads to run
            Thread.yield();
        }
    }

    public int getFound() {
        return found;
    }
}