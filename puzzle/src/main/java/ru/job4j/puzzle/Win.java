package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int index = 0; index != board.length; index++) {
            if (board[index][index] == 1) {
                if (monoHorizontal(board, index) || monoVertical(board, index)) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }

    public static boolean monoHorizontal(int[][] board, int index) {
        boolean result = true;
        for (int i = 0; i != board.length; i++) {
            if (board[index][i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean monoVertical(int[][] board, int index) {
        boolean result = true;
        for (int i = 0; i != board.length; i++) {
            if (board[i][index] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
