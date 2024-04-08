class Solution {
    public int solution(int [][]board) {
        int n = board.length;
        int m = board[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            dp[i][m -1] = board[i][m - 1];
        }
        for(int i = 0; i < m; i++) {
            dp[n - 1][i] = board[n - 1][i];
        }
        int answer = board[0][0];
        for(int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if(board[i][j] == 0) continue;
                dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i + 1][j + 1]), dp[i][j + 1]) + 1;
                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        return answer * answer;
    }
}