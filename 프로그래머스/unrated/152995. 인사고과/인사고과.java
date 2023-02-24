import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] s = scores[0];
        Arrays.sort(scores, (s1, s2) -> s1[0] == s2[0] ? s1[1] - s2[1] : s2[0] - s1[0]);
        ArrayList<Integer> arr = new ArrayList<>();
        int max = 0, ans = 1;
        for(int[] score : scores) {
            if(score[1] < max) {
                if(score.equals(s))
                    return -1;
            }
            else {
                max = Math.max(max, score[1]);
                if(s[0] + s[1] < score[0] + score[1])
                    ans++;
            }
        }
        return ans;
    }
}