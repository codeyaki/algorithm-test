class Solution {
    public int solution(int n) {
        int answer = 0;
        int tmp = 1;
        for(int i = 2; i <= 11; i++){
            tmp *= i;
            if(n < tmp) {
                answer = i - 1;
                break;
            }
        }
        return answer;
    }
}