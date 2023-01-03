import java.io.*;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int minus = nums[1] - nums[0];
        for (int i = 1; i < 8 ; i++) {
            if (nums[i] - nums[i - 1] != minus) {
                minus = 0;
                break;
            }
        }
        if (minus == 1) {
            bw.append("ascending");
        } else if (minus == 0) {
            bw.append("mixed");
        } else {
            bw.append("descending");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
