import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testcase; t++) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]) + 1; // 건물 수 (2 <= n <= 1000), 0번 건물은 없음
            int k = Integer.parseInt(line[1]); // 건물 순서 수 (간선 수, 1 <= k <= 100000)
            int[] buildTime = new int[n];
            int[] inDegree = new int[n];
            List<Integer>[] graph = new List[n];
            // 건물 속도
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n; i++) {
                graph[i] = new ArrayList<>();
                buildTime[i] = Integer.parseInt(st.nextToken());
            }
            // 건물 선후 순
            for (int i = 0; i < k; i++) {
                String[] buildOrder = br.readLine().split(" ");
                int beforeBuild = Integer.parseInt(buildOrder[0]);
                int afterBuild = Integer.parseInt(buildOrder[1]);
                inDegree[afterBuild]++;
                graph[beforeBuild].add(afterBuild);
            }
            int target = Integer.parseInt(br.readLine());
            // 문제 풀이
            int resultTime = calcBuildTime(target, n, graph, buildTime, inDegree);
            sb.append(resultTime).append("\n");

        }
        System.out.println(sb);

    }

    private static int calcBuildTime(int target, int n, List<Integer>[] graph, int[] buildTime, int[] inDegree) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        // 위상 정렬을 통한 건물 생성에 필요한 시간 계산
        int[] totalBuildTime = new int[n];
        for (int i = 1; i < n; i++) {
            totalBuildTime[i] = buildTime[i];
        }
        // inDegree가 0개인 건물 시작
        int startBuilding = findBuildingByInDegreeZero(inDegree, visited);
        visited[startBuilding] = true;
        totalBuildTime[startBuilding] = buildTime[startBuilding];
        que.add(startBuilding);
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int next : graph[now]) {
                // 가장 긴 시간
                totalBuildTime[next] = Math.max(totalBuildTime[next], totalBuildTime[now] + buildTime[next]);
                inDegree[next]--;
            }
            int nextBuilding = findBuildingByInDegreeZero(inDegree, visited);
            if (nextBuilding == -1) continue;
            visited[nextBuilding] = true;
            que.add(nextBuilding);
        }
        return totalBuildTime[target];
    }

    private static int findBuildingByInDegreeZero(int[] inDegree, boolean[] visited) {
        for (int i = 1; i < inDegree.length; i++) {
            if (visited[i]) continue;
            if (inDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
