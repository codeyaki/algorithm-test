import java.io.*;
import java.util.List;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int result;
    private static int targetNumber;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            result = 0;
            targetNumber = Integer.parseInt(br.readLine());
            dfs(0);
            bw.append(String.valueOf(result)).append("\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int sum) {
        // 목표로하는 숫자보다 같거나 높게 도달한 경우
        if (sum >= targetNumber) {
            if (sum == targetNumber) {
                result++;
                return;
            }
            return;
        }
        for (int n = 1; n < 4; n++) {
            dfs(sum + n);
        }

    }
}
