import java.util.HashSet;
import java.util.Set;

class Solution {
    public String solution(String my_string) {
        Set<Character> set = new HashSet<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if(set.contains(c)) continue;
            set.add(c);
            answer.append(c);
        }
        return answer.toString();
    }
}