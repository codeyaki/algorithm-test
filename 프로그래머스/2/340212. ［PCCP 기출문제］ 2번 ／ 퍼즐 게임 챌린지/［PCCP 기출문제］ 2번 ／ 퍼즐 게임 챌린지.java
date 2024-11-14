import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int minLevel = 1;
        int maxLevel = Arrays.stream(diffs).max().getAsInt();
        int level = (minLevel + maxLevel) / 2;
        int answer = 0;
        while(minLevel <= maxLevel) {
            level = (minLevel + maxLevel) / 2;
            long result = solveQuiz(diffs, times, level, limit);
            if(result > limit) {
                minLevel = level + 1;
            }
            else if (result == limit) return level;
            else {
                maxLevel = level - 1;
            }
            
            
        }
        return minLevel;
    }
    
    private long solveQuiz(int[] diffs, int[] times, int level, long limit) {
        int n = diffs.length;
        long totalTime = times[0] * Math.max(diffs[0] - level , 1);
        for (int i = 1; i < diffs.length; i++) {
            long failCnt = Math.max(diffs[i] - level, 0);
            long solveTime = failCnt * (times[i - 1] + times[i]) + times[i];
            totalTime += solveTime;
            
        }
        return totalTime;
    }
}