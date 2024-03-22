import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] boardArr = new char[m][n];
        for(int i = 0; i < m; i++) {
            boardArr[i] = board[i].toCharArray();
        }
        
        boolean isComplete = false;
        int answer = 0;
        while(!isComplete) {
            isComplete = true;
            boolean[][] removeMap = new boolean[m][n];
            for(int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char target = boardArr[i][j];
                    if(target == '.') continue;
                    if(target == boardArr[i + 1][j]
                       && target == boardArr[i][j + 1]
                       && target == boardArr[i + 1][j + 1]
                      ) {
                        removeMap[i][j] = true;
                        removeMap[i + 1][j] = true;
                        removeMap[i][j + 1] = true;
                        removeMap[i + 1][j + 1] = true;
                        isComplete = false;
                    }
                }
            }
            // 지우기
            for(int i = 0; i < n; i++) {
                // 제거할 블럭 '.'으로 만들기
                int removeCount = 0;
                for (int j = 0; j < m; j++) {
                    if(removeMap[j][i]) {
                        boardArr[j][i] = '.';
                        removeCount++;
                    } 
                }
                answer += removeCount;
                // 빈공간 땡기기
                Queue<Character> que = new LinkedList<>();
                for (int j = m - 1 ; j >= 0; j--) {
                    if(boardArr[j][i] == '.') {
                        continue;
                    }
                    que.add(boardArr[j][i]);
                }
                for (int j = m - 1; j >= 0; j--) {
                    if(que.isEmpty()) boardArr[j][i] = '.';
                    else boardArr[j][i] = que.poll();
                }
                
            }
        }
        
        return answer;
    }
}