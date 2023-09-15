import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            char now = s.charAt(i);
            if(!stack.isEmpty() && now == ')' && stack.peek() == '(') stack.pop();
            else stack.push(now);
        }
        return stack.isEmpty();
    }
}