import java.util.Arrays;

class Solution {
    public double solution(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        return sum/ (float) numbers.length;
    }
}