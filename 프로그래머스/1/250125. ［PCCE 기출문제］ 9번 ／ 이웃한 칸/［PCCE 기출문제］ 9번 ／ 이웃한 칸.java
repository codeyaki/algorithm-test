class Solution {
    private int[] dh = {0, 0, -1, 1};
    private int[] dw = {-1, 1, 0, 0};
    public int solution(String[][] board, int h, int w) {
        
        int answer = 0;
        String color = board[h][w];
        for(int i = 0; i < 4; i++){
            int checkH = h + dh[i];
            int checkW = w + dw[i];
            if(checkH < 0 || checkH >= board.length || checkW < 0 || checkW >= board[h].length) continue;
            if(board[checkH][checkW].equals(color)) answer++;
        }
        return answer;
    }
}