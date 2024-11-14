import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        char[] newStr = new char[myString.length()];
        for(int i = 0; i < myString.length(); i++) {
            char inputChar = myString.charAt(i);
            if(inputChar == 'A') inputChar = 'B';
            else if(inputChar == 'B') inputChar = 'A';
            newStr[i] = inputChar;
        }
        String afterString = new String(newStr);
        int answer = afterString.contains(pat) ? 1 : 0;
        return answer;
    }
}