import java.util.*;

class Solution {
    private Stack<Integer> subContainer = new Stack<>();
    
    public int solution(int[] order) {
        int answer = 0;
        for(int i = 1; i <= order.length; i++) {
            if(order[answer] == i) {
                answer++;
                while(!subContainer.isEmpty() && subContainer.peek() == order[answer]) {
                    answer++;
                    subContainer.pop();
                }
            }
            else {
                subContainer.push(i);
            }
            
        }
        return answer;
    }
}