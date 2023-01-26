import java.io.*;
import java.util.*;


public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 정점의 개수
    static int n;
    // 각 정점마다의 거리
    static List<Node>[] distance;
    static boolean[] visited;
    static int longDistance = 0;
    static int longestNode;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        distance = new List[n];
        for (int i = 0; i < n; i++) {
            distance[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode;
            while ((endNode = Integer.parseInt(st.nextToken())) != -1) {
                int dis = Integer.parseInt(st.nextToken());
                distance[startNode - 1].add(new Node(endNode - 1, dis));
            }
        }
        // 0은 단선되어있는 것을 의미한다.
        // dfs를 통해 모든 경우의 두점에 대해 거리계산
        visited = new boolean[n]; // 방문했던 노드는 재방문을 하지 않아야 함
        visited[0] = true;
        dfs(0, 0);
        visited[0] = false;
        // 임의의 노드에서 가장 먼 노드로부터 가장 먼 노드와의 거리가 지름
        visited[longestNode] = true;
        dfs(longestNode, 0);
        visited[longestNode] = false;

        //출력
        bw.append(String.valueOf(longDistance));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int now, int distanceSum) {
        if (distanceSum > longDistance) {
            longestNode = now;
            longDistance = distanceSum;
        }
        for (Node node : distance[now]) {
            int next = node.index;
            if(visited[next]) continue;
            visited[next] = true;
            dfs(next, distanceSum + node.distance);
            visited[next] = false;
        }
    }

    static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "(" + index + ", " + distance + ')';
        }
    }
}