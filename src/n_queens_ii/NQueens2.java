package n_queens_ii;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens
 * attack each other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * @author Alex Pumnea
 */
public class NQueens2 {
    public int totalNQueens(int n) {
        return getSolutionsCount(new int[n], 0, n);
    }

    private int getSolutionsCount(int[] board, int row, int n) {
        if (row == n) return 1;

        int solutionCount = 0;

        for (int col = 0; col < n; col++) {
            if (canPlaceQueen(board, row, col)) {
                board[row] = col;
                solutionCount += getSolutionsCount(board, row + 1, n);
            }
        }
        return solutionCount;
    }

    private boolean canPlaceQueen(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == row - i) {
                return false;
            }
        }
        return true;
    }

}
