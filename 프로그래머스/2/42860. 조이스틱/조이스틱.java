import java.util.*;
class Solution {
    public int solution(String name) {
        // 1. 각 자리별 상하 변경 횟수 구하기
        int answer = 0;
        for(char c : name.toCharArray()) {
            answer += getUpAndDown(c);
        }
        System.out.println(answer);
        // 2. 전체 좌우 횟수 구하기
        answer += getLeftAndRight(name);
        return answer;
    }
    
    private int getUpAndDown(char target) {
        return Math.min(target - 'A', 'Z' - target + 1);
    }
    
    private int getLeftAndRight(String name) {
        int result = 0;
        return result;
    }
    
    
}