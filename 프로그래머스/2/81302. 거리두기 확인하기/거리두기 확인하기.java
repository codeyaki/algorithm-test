import java.util.*;

class Solution {
    private final int N = 5;

    public int[] solution(String[][] places) {
        int[] answer = new int[N]; // 대기실은 5개
        for(int i = 0; i < N; i++) {
            answer[i] = check(places[i]);
        }
        
        return answer;
    }
    
    private int check(String[] place) {
        Queue<int[]> people = new LinkedList<>();
        char[][] board = new char[N][N];
        for(int i = 0; i < N; i++) {
            board[i] = place[i].toCharArray();
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 'P') {
                    if(!isDistanding(board, i, j)) return 0;
                }
            }
        }
        return 1;
    }
    
    private boolean isDistanding(char[][] board, int nowX, int nowY) {
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        
        for(int i = 0; i < 4; i++) {
            int nextX = nowX + dx[i];
            int nextY = nowY + dy[i];
            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
            if(board[nextX][nextY] == 'P') return false;
            if(board[nextX][nextY] == 'X') continue;
            else if(board[nextX][nextY] == 'O') {
                // 책상인 경우 확인해야함
                for(int j = 0; j < 4; j++) {
                    int boardNextX = nextX + dx[j];
                    int boardNextY = nextY + dy[j];
                    if(boardNextX < 0 || boardNextY < 0 
                       || boardNextX >= N || boardNextY >= N) continue;
                    if(boardNextX == nowX && boardNextY == nowY) continue;
                    if(board[boardNextX][boardNextY] == 'P') return false;
                }
                
            }
        }
        return true;
    }
}