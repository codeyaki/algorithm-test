import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = Arrays.stream(arr).map(o1 -> {
            if(o1 >= 50 && o1 % 2 == 0){
                return o1/2;
            }else if(o1 < 50 && o1 % 2 == 1){
                return o1*2;
            }
            return o1;
        }).toArray();
        return answer;
    }
}