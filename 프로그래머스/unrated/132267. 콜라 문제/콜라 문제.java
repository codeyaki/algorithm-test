class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            int change = n / a * b;
            answer += change;
            n  =  n % a + change;
        }
        return answer;
    }
}