class Solution {
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int answer = n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    // 폭탄이 있는 경우
                    answer--;
                    for (int k = 0; k < 8; k++) {
                        int checkX = i + dx[k];
                        int checkY = j + dy[k];
                        // board 넘어가는 경우 넘어감
                        if (checkX < 0 || checkY < 0 || checkX >= n || checkY >= m) continue;
                        // 이미 폭탄이 놓여졌거나 안전지대가 아닌 경우 넘어감
                        if (board[checkX][checkY] > 0) continue;
                        board[checkX][checkY] = 2;
                        answer--;
                    }
                }
            }
        }
        return answer;
    }
}