import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = 0, end = n - 1;
        int min = Integer.MAX_VALUE;
        int[] answerIndex = new int[] { 0, 0 };
        while (start < end) {
            int sum = Math.abs(nums[end] + nums[start]);

            // 기존에 기록했던 정답보다 차이가 적다면 기록
            if (sum < min) {
                min = sum;
                answerIndex[0] = start;
                answerIndex[1] = end;
            }

            // 1. 합이 0일 경우 바로 정답
            if (sum == 0)
                break;

            // 2. 합이 양수일 경우
            if (nums[end] + nums[start] > 0)
                end--;

            // 3. 합이 음수일 경우
            else
                start++;
        }

        System.out.println(nums[answerIndex[0]] + " " + nums[answerIndex[1]]);
    }
}
