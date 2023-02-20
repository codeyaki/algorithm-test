class Solution {
    public int solution(int balls, int share) {
        long answer = 1;
        for (int i = balls; i > share; i--) {
            answer *= i;
            answer /= balls + 1 - i;
        }
        return (int) answer;
    }
}