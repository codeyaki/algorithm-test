import java.util.*;

class Solution {    
    public int solution(int[] topping) {
        int n = topping.length;
        // 왼쪽 가지수 누적합
        int[] countLeft = new int[n];
        Set<Integer> setLeft = new HashSet<>();
        // 오른쪽 가지수 누적합
        int[] countRight = new int[n];
        Set<Integer> setRight = new HashSet<>();
        
        for(int i = 0; i < n - 1; i++) {
            setLeft.add(topping[i]);
            setRight.add(topping[n - i - 1]);
            countLeft[i] = setLeft.size();
            countRight[n - i - 2] = setRight.size();
        }
        
        int answer = 0;
        for(int i = 0; i < n - 1; i++){
            if(countLeft[i] == countRight[i]) answer++;
        }
        
        return answer;
    }
}