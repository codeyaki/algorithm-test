class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int number : array){
            while (number > 1){
                if(number%10 == 7) answer++;
                number /= 10;
            }
        }
        return answer;
    }
}