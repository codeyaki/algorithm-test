import java.io.*;
import java.util.Arrays;

public class Main {

    static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static private final int COUNT_NUMBER = 1000 + 1;
    static private boolean[] isNotPrimeNumberList = new boolean[COUNT_NUMBER];

    public static void main(String[] args) throws IOException {
        eratosthenes();
        int t = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Integer result = solution(nums);
        bw.append(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int solution(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (!isNotPrimeNumberList[num]) {
                result++;
            }
        }
        return result;
    }

    private static void eratosthenes() {
        isNotPrimeNumberList[0] = isNotPrimeNumberList[1] = true;
        for (int i = 2; i < Math.sqrt(COUNT_NUMBER) + 1; i++) {
            if (!isNotPrimeNumberList[i]) {
                for (int j = i * 2; j < COUNT_NUMBER; j += i) {
                    isNotPrimeNumberList[j] = true;
                }
            }
        }
    }
}
