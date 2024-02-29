package org.charles.coding.leetcode;

/**
 * Given is a matrix with 1 and 0.
 * 1 represents land and 0 water (consider the edge of the matrix is water)
 * Find the number of islands in this matrix.
 * The land can be connected both horizontally and vertically.
 *
 * e.g
 *
 * 1 1 0 0
 * 1 0 0 0
 * 0 0 1 0
 * 0 0 0 1
 */
public class NumberOfIslands {


    public static void main(String[] args) {
        // Creating the matrix
        MatrixProvider matrixProvider = new MatrixProvider(4, 4);
        matrixProvider.addLand(0, 0);
        matrixProvider.addLand(0, 1);
        matrixProvider.addLand(1, 0);
        matrixProvider.addLand(2, 2);
        matrixProvider.addLand(3, 3);
        System.out.println(matrixProvider);
        int[][] matrix = matrixProvider.getMatrix();
        System.out.println(dfs(matrix, matrixProvider.getRow(), matrixProvider.getCol()));
    }

    private static int dfs(int[][] matrix, int row, int col){
        boolean[][] visited = new boolean[row][col];
        int numOfIsland=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(!visited[i][j] && matrix[i][j] == 1){
                    dfs(visited, matrix, i, j);
                    numOfIsland++;
                }
            }
        }
        return numOfIsland;
    }

    private static void dfs(boolean[][] visited, int[][] matrix, int row, int col) {
        if(row < 0 || col < 0
                || row >= matrix.length || col >= matrix.length
                || matrix[row][col] == 0
                || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        dfs(visited, matrix, row, col-1); // left
        dfs(visited, matrix, row-1, col); // up
        dfs(visited, matrix, row, col+1); // right
        dfs(visited, matrix, row+1, col); // down
    }
}

class MatrixProvider {
    private int[][] matrix;
    private int row;
    private int col;

    public MatrixProvider(int row, int col) {
        this.row = row;
        this.col = col;
        this.matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.matrix[i][j] = 0;
            }
        }
    }

    public int[][] getMatrix(){
        return this.matrix;
    }

    public void addLand(int row, int col){
        this.matrix[row][col] = 1;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                sb.append(this.matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
