import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static String[][] board;
    private static int queenNum;

    public static void main(String[] args) {
        System.out.print("Input number of queens: ");
        Scanner s = new Scanner(System.in);
        queenNum = s.nextInt();

        resetBoard();
        solveQueensProblem();
    }

    private static void solveQueensProblem() {
        int queensPlaced = 0;
        for (int i = 0; i < queenNum; i++) {
            for (int col = 0; col < queenNum; col++) {
               for (int row = 0; row < queenNum; row++) {
                    if (!board[row][col].equals("x")) {
                        board[row][col] = "Q";
                       queensPlaced++;
                       eliminateQueenSpaces(row, col);
                       if (queensPlaced == queenNum) {
                           for (String[] finishedRow : board) {
                               System.out.println(Arrays.toString(finishedRow));
                           }
                           System.out.println();
                           resetBoard();
                           queensPlaced = 0;
                           col = queensPlaced;
                        }
                    }
               }
            }
        }
    }

    private static void eliminateQueenSpaces(int row, int col) {
        for (int i = 0; i < queenNum; i++) {
            if (!board[row][i].equals("Q")) {
                board[row][i] = "x";
            }
            if (!board[i][col].equals("Q")) {
                board[i][col] = "x";
            }
            if (row-(i+1) >= 0) {
                if (col-(i+1) >= 0) {
                    board[row-(i+1)][col-(i+1)] = "x";
                }
                if (col+(i+1) < queenNum) {
                    board[row-(i+1)][col+(i+1)] = "x";
                }
            }
            if (row+(i+1) < queenNum) {
                if (col-(i+1) >= 0) {
                    board[row+(i+1)][col-(i+1)] = "x";
                }
                if (col+(i+1) < queenNum) {
                    board[row+(i+1)][col+(i+1)] = "x";
                }
            }
        }
    }

    private static void resetBoard() {
        board = new String[queenNum][queenNum];
        for (int row = 0; row < queenNum; row++) {
            for (int col = 0; col < queenNum; col++) {
                board[row][col] = "-";
            }
        }
    }
}
