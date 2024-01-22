import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            StringBuilder sb = new StringBuilder(s);
            String sub = sb.substring(0, i);
            sb.delete(0, i);
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