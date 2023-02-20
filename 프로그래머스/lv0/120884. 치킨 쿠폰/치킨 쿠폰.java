class Solution {
    public int solution(int chicken) {
        int answer = 0;
        while(chicken > 10){
            int rest = chicken % 10;
            chicken /= 10;
            answer += chicken;
            chicken += rest;
        }
        return answer + chicken/10;
    }
}