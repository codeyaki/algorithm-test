class Solution {
    int[] board;
    int n;
    int answer = 0;
    boolean[] cols;
    boolean[] diag1;
    boolean[] diag2;

    public int solution(int n) {
        init(n);
        dfs(0);
        return answer;   
    }
    
    private void dfs(int row) {
        if (row == n) {
            answer++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols[col] || diag1[row - col + n - 1] || diag2[row + col]) {
                continue;
            }
            board[row] = col;
            cols[col] = true;
            diag1[row - col + n - 1] = true;
            diag2[row + col] = true;
            dfs(row + 1);
            cols[col] = false;
            diag1[row - col + n - 1] = false;
            diag2[row + col] = false;
        }
    }
    
    private void init(int n) { 
        this.board = new int[n];
        this.cols = new boolean[n];
        this.diag1 = new boolean[2 * n - 1];
        this.diag2 = new boolean[2 * n - 1];
        this.n = n;
    }
    
    private void printBoard() {
        for (int i = 0; i < n; i++) {
            System.out.print(board[i] + ", ");
        }
        System.out.println();
    }
}
