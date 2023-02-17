import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        String lowerCase = my_string.toLowerCase();
        int n = my_string.length();
        char[] charArr = new char[n];
        for (int i = 0; i < n; i++) {
            charArr[i] = lowerCase.charAt(i);
        }
        Arrays.sort(charArr);
        StringBuffer answer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            answer.append(charArr[i]);
        }
        return answer.toString();
    }
}