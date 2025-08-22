package com.example.algorithms.backtrack;

public class _79_WordSearch {
    private boolean result;
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        backtrack(board, word, visited, 0, 0, 0);
        return result;
    }

    private void backtrack(char[][] board,
                              String word,
                              boolean[][] visited,
                              int row, int col, int wordPos) {
        int rowLimit = board.length - 1;
        int colLimit = board[0].length - 1;
        int wordLimit = word.toCharArray().length - 1;
        if (result || wordPos > wordLimit) {
            result = true;
            return;
        }
        if (row > rowLimit || row < 0 || col < 0 || col > colLimit || visited[row][col]) return;
        if (board[row][col] == word.charAt(wordPos) && wordPos < wordLimit) {
            visited[row][col] = true;
            for (int i = row-1; i < row+2; i+=2) {
                for (int j = col-1; j < col + 2; j+=2) {
                    backtrack(board, word, visited, i, j, wordPos + 1);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
