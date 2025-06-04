import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] capacity = new int[players.length];
        for(int i = 0; i < players.length; i++) {
            if((capacity[i] + 1) * m <= players[i]) {
                int count = (players[i] - capacity[i] * m) / m;
                answer += count;
                for(int j = i; j < Math.min(i + k, players.length); j++) {
                    capacity[j] += count;
                }
            }
        }
        
        return answer;
    }
}