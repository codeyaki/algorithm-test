import java.io.*;
import java.util.StringTokenizer;
import java.util.logging.Level;


public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int[] numArr;
    private static int n;
    private static int[] lottoArr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 입력
        String line;
        while (!"0".equals(line = br.readLine())) {
            StringTokenizer st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            numArr = new int[n];
            lottoArr = new int[6];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }
            // 풀이
            bfs(0, 0);
            sb.append("\n");
        }
        bw.append(sb.toString());
        // 출력
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int now, int length) {
        if (length == 6) {
            for (int lotto : lottoArr) {
                sb.append(lotto).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int next = now; next < n; next++) {
            if(visited[next]) continue;
            visited[next] = true;
            lottoArr[length] = numArr[next];
            bfs(next, length + 1);
            visited[next] = false;
        }
    }


}
