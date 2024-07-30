if ele = 0, make entire row and col = 0. in place.

class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] rowFlag = new boolean[rows];
        boolean[] colFlag = new boolean[cols];

        // First pass: find all the rows and columns that have 0s
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }

        // Second pass: set the entire row to 0s if the rowFlag is true
        for (int i = 0; i < rows; i++) {
            if (rowFlag[i]) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Third pass: set the entire column to 0s if the colFlag is true
        for (int j = 0; j < cols; j++) {
            if (colFlag[j]) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
