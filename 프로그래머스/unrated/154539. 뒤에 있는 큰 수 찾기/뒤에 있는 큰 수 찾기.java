import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for(int i = 1; i < numbers.length; i++){
            int value = numbers[i];
            while (!stack.isEmpty() && numbers[stack.peek()] < value) answer[stack.pop()] = value;
            stack.push(i);
        }
        return answer;
    }
}