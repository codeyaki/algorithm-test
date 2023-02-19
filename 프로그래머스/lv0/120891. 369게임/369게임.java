class Solution {
    public int solution(int order) {
        int answer = 0;
        while(order > 0){
            int rest = order % 10;
            if( rest == 3 || rest == 6 || rest == 9) answer++;
            order /= 10;
        }
        return answer;
    }
}