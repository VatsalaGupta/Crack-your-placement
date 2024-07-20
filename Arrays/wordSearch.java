package Arrays;

public class wordSearch {
    public static void main(String[] args) {
        char[][] board = {  // Properly declare and initialize the board
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";  // Properly declare and initialize the word
        boolean result = exist(board, word);  // Call the exist method
        System.out.println("The word " + word + (result ? " exists" : " does not exist") + " in the board.");
    }

    public static boolean exist(char[][] board, String word) {  // Declare the method as static
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, word, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private static boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {  // Declare the method as static
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        visited[i][j] = true;
        
        if (backtrack(board, word, visited, i + 1, j, index + 1) ||
            backtrack(board, word, visited, i - 1, j, index + 1) ||
            backtrack(board, word, visited, i, j + 1, index + 1) ||
            backtrack(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}
