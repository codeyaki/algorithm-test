import java.io.*;
import java.util.StringTokenizer;


public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int n, s, result=0;
    private static int[] numArr;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        visited = new boolean[n];
        numArr = new int[n];
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        // 풀이
        dfs(0, 0, 0);
        bw.append(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int point, int length, int sum) throws IOException {
        if (length > 0 && sum == s) {
            result++;
        }
        for (int i = point; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(i, length + 1, sum + numArr[i]);
            visited[i] = false;
        }

    }
}
