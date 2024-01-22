import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++){
            String sub = sb.substring(0, 1);
            sb.delete(0, 1);
            sb.append(sub);
            if(checkString(sb.toString())) answer++;
        }
        
        return answer;
    }
    
    
    private boolean checkString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!stack.isEmpty()) {
                if(c == ']') {
                    if (stack.peek() == '[') stack.pop();
                } else if (c == '}') {
                    if (stack.peek() == '{') stack.pop();
                } else if (c == ')') {
                    if (stack.peek() == '(') stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
            
        }
        
        return stack.isEmpty();
    }
}