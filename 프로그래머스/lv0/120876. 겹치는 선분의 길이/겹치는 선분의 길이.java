import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int end = -100;
        int start = 100;
        for (int i = 0; i < 3; i++) {
            end = Math.max(end, lines[i][1]);
            start = Math.min(start, lines[i][0]);
        }
        for(int i = start; i < end; i++){
            int cntLine = 0;
            for(int[] line : lines){
                if(line[0] <= i && line[1] >= i+1) cntLine++;
            }
            if(cntLine > 1) answer ++;
        }
        return answer;
    }
}