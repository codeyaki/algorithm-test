import java.io.*;
import java.util.Arrays;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int[][] map;
    public static void main(String[] args) throws IOException {
        int[] nmb = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmb[0]; int m = nmb[1]; int b = nmb[2];
        map = new int[n][m];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(line[j]);
                map[i][j] = num;
                sum += num;
                max = Math.max(max, num);
            }
        }

        // 땅 고르기
        int minTime = (int) (Math.pow(2, 31) - 1);
        int resultHigh = 0;
        for (int high = 0; high <= max; high++) {
            int sumTime = 0;
            // 땅고르기를 위해서는 최대 블럭의 개수를 넘어가지 않아야 함
            if ((high * m * n) <= sum + b) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        // 한칸씩 돌면서 파야하는지 블럭을 둬야하는지 계산
                        // 파야하는 경우 2초 (목표층 < 현재층)
                        // 둬야하는 경우 1초 (목표층 > 현재층)
                        int minus = (high - map[i][j]);
                        if (minus < 0) {
                            minus = - minus * 2;
                        }
                        sumTime += minus;
                    }
                }
                if (sumTime <= minTime) {
                    minTime = sumTime;
                    resultHigh = high;
                }
            }
        }
        bw.append(String.valueOf(minTime)).append(" ").append(String.valueOf(resultHigh));

        bw.flush();
        bw.close();
        br.close();
    }
}
