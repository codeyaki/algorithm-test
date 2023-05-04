import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.io.IOException;

public class Main {

    private static Queue<Integer>[] queues;
    private static int[] inDegree;
    private static boolean[] visited;
    private static int n;
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]) + 1; // 학생들의 번호는 1 부터 n
        int m = Integer.parseInt(line[1]); // 간선 수
        visited = new boolean[n];
        inDegree = new int[n]; // i로 들어오는 경우
        queues = new Queue[n];
        for (int i = 0; i < n; i++) {
            queues[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            queues[start].add(end);
            // inDegree 증가
            inDegree[end]++;
        }

        // 문제풀이
        solution();

        // 출력
        StringBuffer sb = new StringBuffer();
        for (Integer student : answer) {
            sb.append(student).append(" ");
        }
        System.out.println(sb);
    }

    private static void solution() {
        // 위상정렬 사용
        Queue<Integer> que = new LinkedList<>();
        // 들어오는 간선의 개수가 0인 가장 작은 수 que 삽입
        que.add(minInDegreeNode());
        while (!que.isEmpty()) {
            Integer now = que.poll();
            answer.add(now);
            // 연결된 노드들 inDegree 1씩 감소
            for (Integer node : queues[now]) {
                inDegree[node]--;
            }
            // 다시 0인 노드 확인
            int next = minInDegreeNode();
            if(next > 0 ) que.add(next);
        }

    }

    private static int minInDegreeNode() {
        // 방문하지 않은 노드중 들어오는 간선의 개수가 0인 노드 찾기
        for (int i = 1; i < n; i++) {
            if (visited[i]) continue;
            if (inDegree[i] == 0) {
                visited[i] = true;
                return i;
            }
        }
        return -1;
    }
}