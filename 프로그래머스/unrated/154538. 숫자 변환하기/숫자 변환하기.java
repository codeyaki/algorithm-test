import java.util.*;

class Solution {

    int[] dp = new int[3000003];
    int INF = 1000002;

    public int solution(int x, int y, int n) {
        int answer = 0;
        Arrays.fill(dp, INF);
        dp[x] = -1;
        dp[y] = 0;
        for(int num = Math.max(y - n, Math.max(y / 2, y / 3)); num >= x; num--){
            dp[num] = Math.min(dp[num + n] + 1, Math.min(dp[num * 2] + 1, dp[num * 3] + 1));
        }
        return dp[x] >= INF ? -1 : dp[x];
    }
}