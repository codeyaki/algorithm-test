import java.util.*;

class Solution {
    public String solution(String s) {
        int[] cntBook = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            cntBook[s.charAt(i) - 'a']++;
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < cntBook.length; i++){
            if(cntBook[i] == 1) answer.append((char) (i + 'a'));
        }
        return answer.toString();
    }
}