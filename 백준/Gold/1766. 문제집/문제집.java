import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        int[] inDegreeArr = new int[n + 1];
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int before = Integer.parseInt(line[0]);
            int after = Integer.parseInt(line[1]);
            graph[before].add(after);
            inDegreeArr[after]++;
        }
        Solution solution = new Solution(n, m, graph, inDegreeArr);
        int[] result = solution.getAnswer();
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }

    }
}

class Solution {
    int n, m;
    List<Integer>[] graph;
    int[] inDegreeArr;
    boolean[] visited;

    public Solution(int n, int m, List<Integer>[] graph, int[] inDegreeArr) {
        this.n = n;
        this.m = m;
        this.graph = graph;
        this.inDegreeArr = inDegreeArr;
        visited = new boolean[n + 1];
    }

    public int[] getAnswer() {
        int[] result = new int[n];
        // 위상정렬 bfs
        Queue<Integer> que = new LinkedList<>();
        // inDegree가 0인것중 가장 낮은것
        que.add(findMinNode());
        int idx = 0;
        while (!que.isEmpty()) {
            int node = que.poll();
            result[idx++] = node;
            for (Integer next : graph[node]) {
                inDegreeArr[next] = Math.max(inDegreeArr[next] - 1, 0);
            }
            // 다음 노드 삽입
            int nextNode = findMinNode();
            if (nextNode == -1) continue;
            que.add(nextNode);
        }
        return result;
    }

    private int findMinNode() {
        // inDegree가 0인것중 가장 낮은것 찾기
        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) continue;
            if (inDegreeArr[i] == 0) {
                visited[i] = true;
                return i;
            }
        }
        return -1;
    }

}
