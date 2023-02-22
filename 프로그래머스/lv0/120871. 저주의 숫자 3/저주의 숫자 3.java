class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer++;
            while (checkThree(answer)) answer++;
        }
        return answer;

    }

    private boolean checkThree(int number) {
        if (String.valueOf(number).contains("3")) return true;
        if (number % 3 == 0) return true;
        return false;
    }
}