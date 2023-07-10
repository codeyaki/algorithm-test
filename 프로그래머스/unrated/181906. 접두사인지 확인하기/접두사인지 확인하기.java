class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = my_string.startsWith(is_prefix) ? 1 : 0;
        return answer;
    }
}