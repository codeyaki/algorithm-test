import java.util.*;
class Solution {
    public int solution(String name) {
        char[] nameCharArr = name.toCharArray();
        int n = nameCharArr.length;
        int answer = 0;
        int move = n - 1;
        for(int start = 0; start < n; start++) {
            //1. 'A'가 아니면 알파벳 조작
            if(nameCharArr[start] != 'A') answer += getUpAndDown(nameCharArr[start]);
            //2.최소횟수 구하기
            int end = start + 1;
            while(end < n && nameCharArr[end] == 'A') end++;
            int temp = Math.min(2 * start + n - end, start + 2 * (n - end));
            move = Math.min(move, temp);            
        }
        answer += move;
        return answer;
    }
    
    private int getUpAndDown(char target) {
        return Math.min(target - 'A', 'Z' - target + 1);
    }
    
}