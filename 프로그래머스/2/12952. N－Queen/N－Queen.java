class Solution {
    int[] board;
    int n;
    int answer = 0;
    public int solution(int n) {
        init(n);
        dfs(0);
        return answer;   
    }
    
    private void dfs(int row) {
        if(row == n) {
            answer++;
            return;
        }
        for (int j = 0; j < n; j++) {
            board[row] = j;
            // 현재 있는곳에 두기 가능한지 확인
            if(!canPlaceQueen(row)) {
                board[row] = -1;
                continue;
            }
            // 되면 다음 수 두기
            dfs(row + 1);
            board[row] = -1;
        }
        
    }
    
    private boolean canPlaceQueen(int x) {
        for(int i = 0; i < x; i++) {
            if(board[x] == board[i]) return false;
            if(Math.abs((float) (board[x] - board[i]) / (x - i)) == 1.0) return false;
        }
        return true;
    }
    
    private void init(int n) { 
        this.board = new int[n];
        for(int i = 0; i < n; i++) {
            this.board[i] = -1;
        }
        this.n = n;
    }
    
    private void printBoard() {
        for(int i = 0; i < n; i++) {
            System.out.print(board[i] + ", ");
        }
        System.out.println();
    }
}
