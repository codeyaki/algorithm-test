import java.io.*;
import java.util.Arrays;


public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static int[][] cost;
    private static boolean[] visited;
    private static int result = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        // 입력
        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 풀이
        // 한마을씩 시작으로 돌아다니기
        for (int startSity = 0; startSity < n; startSity++) {
            visited[startSity] = true;
            tsp(startSity, startSity, 1, 0);
            visited[startSity] = false;

        }
        bw.append(String.valueOf(result));

        // 출력
        bw.flush();
        bw.close();
        br.close();
    }

    private static void tsp(int start, int now, int length, int sum) {
        if (length == n) {
            // 모든 마을을 돌은 후 처음 마을로 돌아가야함. (갈수있어야 함)
            int backStartCost = cost[now][start];
            if (backStartCost != 0) {
                result = Math.min(result, sum + backStartCost);
            }
            return;
        }
        // 다음으로 방문할 곳 찾기
        for (int next = 0; next < n; next++) {
            int nextVisitCost = cost[now][next]; // 다음 이동 비용
            // 방문하지 않았던 곳이며 갈 수 있는 곳이야 함
            if(visited[next] || nextVisitCost == 0) continue;

            visited[next] = true;
            int nextSum = sum + nextVisitCost;
            tsp(start, next, length + 1, nextSum);
            visited[next] = false;

        }
    }
}