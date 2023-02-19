import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int d = direction.equals("right") ? numbers.length - 1 : 1;
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[(i + d) % numbers.length];
        }
        return answer;
    }
}