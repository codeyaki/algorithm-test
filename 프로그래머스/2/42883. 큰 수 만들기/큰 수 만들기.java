import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - 48;
            while(!stack.isEmpty() && stack.peek() < num && k > 0) {
                k--;
                stack.pop(); 
            }
            stack.push(num);
        }
        // 모두 종료후 k가 남아있다면 맨뒤에서 빼주기
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stack.size() - k; i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}