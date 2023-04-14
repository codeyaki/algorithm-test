import java.util.*;

class Solution {
    private boolean[] isIntercept;
    public int solution(int[][] targets) {
        isIntercept = new boolean[targets.length];
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        int answer = 0;
        return answer;
    }
}