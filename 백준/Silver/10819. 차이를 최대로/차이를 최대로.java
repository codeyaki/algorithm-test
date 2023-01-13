import javax.management.MBeanServerFactory;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static boolean[] visited;
    private static int[] numArr;
    private static int maxAbs = 0;

    private static int[] testArr;

    public static void main(String[] args) throws IOException {
        // 입력
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        numArr = new int[n];
        testArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        bfs(0, 0, 0);
        bw.append(String.valueOf(maxAbs));

        // 출력
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int preindex, int length, int sum) {
        if (length == n) {
            maxAbs = Math.max(maxAbs, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            // sum = arr[length - 1] - arr[length]
            int nextSum = 0;
            if (length > 0) {
                nextSum = sum + Math.abs(numArr[preindex] - numArr[i]);
            }
            visited[i] = true;
            bfs(i, length + 1, nextSum);
            visited[i] = false;
        }
    }


}
