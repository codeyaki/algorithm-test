class Solution {
    public int solution(String my_string) {
        int answer = 0;
        boolean continueDigit = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (Character.isDigit(c)) {
                // 첫 시작인 경우
                if (!continueDigit) {
                    continueDigit = true;
                }
                sb.append(c);
            // 숫자가 아닌 경우
            }else {
                // 이전까지 숫자였던 경우
                if (continueDigit) {
                    answer += Integer.parseInt(sb.toString());
                }
                continueDigit = false;
                sb = new StringBuilder();
            }
        }
        // 마지막이 숫자였을 경우
        if (continueDigit) {
            answer += Integer.parseInt(sb.toString());
        }
        return answer;
    }
}