import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        
        long[] preFact = new long[n];
        preFact[n - 1] = 1;
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i < n; i++){
            preFact[n - 1 - i] = preFact[n - i] * i;
            nums.add(i);
        }
        nums.add(n);
        int[] answer = new int[n];
        for(int i = 0; i < n - 1; i++) {
            long value = k / preFact[i];
            k = k % preFact[i];
            if(value > 0 && k == 0) {
                value--;
                k = preFact[i + 1] * (nums.size() - 1);
            }
            answer[i] = nums.get((int) value);
            nums.remove((int) value);
            
        }
        answer[n - 1] = nums.get(0);
        return answer;
    }
}