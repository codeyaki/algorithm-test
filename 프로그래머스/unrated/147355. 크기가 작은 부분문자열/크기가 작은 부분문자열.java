class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long intP = Long.parseLong(p);
        int length = p.length();
        for (int i = 0; i < t.length() - length + 1; i++) {
            if (Long.parseLong(t.substring(i, i + length)) <= intP) answer++;
        }
        return answer;
    }
}