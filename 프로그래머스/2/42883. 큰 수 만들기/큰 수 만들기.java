import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - 48;
            while(k > 0 && !stack.isEmpty() && stack.peek() < num) {
                stack.pop(); 
                k--;
            }
            stack.push(num);
        }
        // 모두 종료후 k가 남아있다면 맨뒤에서 빼주기
        for(int i = 0; i < k; i++) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(String.valueOf(stack.pop()));
        String answer = sb.reverse().toString();
        return answer;
    }
}