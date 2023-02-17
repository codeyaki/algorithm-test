class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[(int) Math.ceil((double) my_str.length() / (double) n)];
        int length = 0;
        for (int i = 0; i < my_str.length() / n; i++) {
            answer[i] = my_str.substring(i * n, i * n + n);
            length += n;
        }
        if (length < my_str.length()) {
            answer[answer.length-1] = my_str.substring(length);
        }
        return answer;
    }
}