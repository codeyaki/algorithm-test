import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()) + 1;
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 2; i++) {
            String[] split = br.readLine().split(" ");
            int node1 = Integer.parseInt(split[0]);
            int node2 = Integer.parseInt(split[1]);
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        int[] result = solve(n, graph);
        for(int i = 2; i < n; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();

    }

    private static int[] solve(int n, List<Integer>[] graph) {
        int[] result = new int[n];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{1, 0}); // 자식 - 부모
        boolean[] visited = new boolean[n];
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            result[cur[0]] = cur[1];
            for(int next : graph[cur[0]]) {
                if(visited[next]) continue;
                visited[next] = true;
                que.add(new int[]{next, cur[0]});
            }
        }
        return result;
    }

}
