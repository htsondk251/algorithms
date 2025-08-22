package com.example.algorithms.backtrack;

public class _79_WordSearch {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, new boolean[board.length][board[0].length], i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board,
                              String word,
                              boolean[][] visited,
                              int row, int col, int wordPos) {
        int rows = board.length;
        int cols = board[0].length;
        if (wordPos == word.length()) {
            return true;
        }
        if (row > rows - 1 || row < 0 || col < 0 || col > cols - 1 ||
                visited[row][col] ||
                board[row][col] != word.charAt(wordPos)) {
            return false;
        }

        visited[row][col] = true;

        boolean found =
                backtrack(board, word, visited, row - 1, col, wordPos + 1) ||
                backtrack(board, word, visited, row + 1, col, wordPos + 1) ||
                backtrack(board, word, visited, row, col - 1, wordPos + 1) ||
                backtrack(board, word, visited, row, col + 1, wordPos + 1);

        visited[row][col] = false;

        return found;
    }

    public static void main(String[] args) {
        _79_WordSearch i = new _79_WordSearch();
        System.out.println(i.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'E', 'E', 'E'}
        }, "ABCCED"));
        System.out.println(i.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE"));
        System.out.println(i.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB"));
        System.out.println(i.exist(new char[][]{{'a'}}, "a"));
    }
}
