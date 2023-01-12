import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static boolean[] visited;
    private static int[] numArr;

    public static void main(String[] args) throws IOException {
        // 입력
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        numArr = new int[n];

        // 풀이
        makePermutation(0);

        // 출력
        bw.flush();
        bw.close();
        br.close();
    }

    private static void makePermutation(int length) throws IOException {
        if (length == n) {
            for (int n : numArr) {
                bw.append(String.valueOf(n)).append(" ");
            }
            bw.append("\n");
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            numArr[length] = i;
            makePermutation(length + 1);
            visited[i] = false;
        }
    }
}