class Solution {
    public int solution(int n) {
        boolean isOddN = n % 2 == 1;
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            boolean isOddI = i % 2 == 1;
            if(isOddN == isOddI) answer += isOddI ? i : Math.pow(i, 2);
        }
        return answer;
    }
}