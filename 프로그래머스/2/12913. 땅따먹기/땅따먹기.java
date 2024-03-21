import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int[][] dp = new int[n][4];
        for(int j = 0; j < 4; j++) {
            dp[0][j] = land[0][j];
        }
        for(int i = 1; i < n; i++) {
            // 같은 열의 이전을 제외한 것중 가장 큰 경우
            for(int j = 0; j < 4; j++) {
                for(int k = 0; k < 4; k++) {
                    if(j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + land[i][j]);
                }
            }
        }
        
        // 마지막 열 max 확인
        return Arrays.stream(dp[n - 1]).max().getAsInt();
        
    }
}