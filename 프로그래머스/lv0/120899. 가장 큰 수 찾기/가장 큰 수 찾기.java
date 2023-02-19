class Solution {
    public int[] solution(int[] array) {
        int[] answer = {Integer.MIN_VALUE, - 1};
        for(int i = 0; i < array.length; i++){
            if(answer[0] < array[i]){
                answer = new int[]{array[i], i};
            }
        }
        return answer;
    }
}