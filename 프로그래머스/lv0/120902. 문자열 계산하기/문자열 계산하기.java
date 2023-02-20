import java.util.StringTokenizer;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        StringTokenizer st = new StringTokenizer(my_string);
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.equals("-")) {
                answer -= Integer.parseInt(st.nextToken());
            } else if (s.equals("+")) {
                answer += Integer.parseInt(st.nextToken());
            } else {
                answer += Integer.parseInt(s);
            }
        }

        return answer;
    }
}