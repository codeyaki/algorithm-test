import java.io.*;
import java.util.Arrays;


public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static int[][] graph;
    private static int result = Integer.MAX_VALUE;
    private static boolean[] visited;
    private static int start;


    public static void main(String[] args) throws IOException {
        // 입력
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 풀이
        dfs(0, 0, 0);
        bw.append(String.valueOf(result));

        // 출력
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int point, int length, int sum) {
        if (length == n + 1) {
            if (start == point) {
                result = Math.min(result, sum);
            }
            return;
        }
        // 첫 방문 기억하기
        if (length == 1) {
            start = point;
        }
        // 마지막 방문
        if (length == n && graph[point][start] != 0) {
            dfs(start, length + 1, sum + graph[point][start]);
        }
        // 다음으로 방문할 곳 찾기
        for (int i = 0; i < n; i++) {
            // 1번째 방문 부터는 방문했던 곳과 갈수없는곳 제외하기
            if (length > 0 && (visited[i] || graph[point][i] == 0)) continue;
            int newSum = sum + graph[point][i];
            visited[i] = true;
            dfs(i, length + 1, newSum);
            visited[i] = false;
        }

    }


}
