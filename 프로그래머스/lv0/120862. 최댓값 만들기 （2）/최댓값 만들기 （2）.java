import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int plusMax = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        int minusMax = numbers[0] * numbers[1];
        int answer = Math.max(plusMax, minusMax);
        return answer;
    }
}