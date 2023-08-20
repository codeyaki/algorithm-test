class Solution {
    public int solution(String num_str) {
        int answer = 0;
        for(String numString : num_str.split("")){
            answer += Integer.parseInt(numString);
        }
        return answer;
    }
}