import java.util.StringTokenizer;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int pre = 0;
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            String str= st.nextToken();
            if (str.equals("Z")) {
                answer -= pre;
            } else {
                pre = Integer.parseInt(str);
                answer += pre;
            }
        }
        return answer;
    }
}