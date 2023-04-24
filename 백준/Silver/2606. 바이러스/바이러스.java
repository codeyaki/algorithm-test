import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int n, answer;

    public static void main(String[] args) throws IOException {
        read();
        bfs();
        print();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        graph = new List[n + 1];
        for(int i = 0; i < n + 1; i++){
            graph[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            String[] input = br.readLine().split(" ");
            int computer1 = Integer.parseInt(input[0]);
            int computer2 = Integer.parseInt(input[1]);
            graph[computer1].add(computer2);
            graph[computer2].add(computer1);
        }
    }

    private static void bfs() {
        // 1부터 시작해서 같은 네트워크 전부 제거
        Queue<Integer> que = new LinkedList();
        que.add(1);
        visited[1] = true;
        int count = -1; // 1은 제외해야 한다.
        while(!que.isEmpty()){
            int now = que.poll();
            count++;
            // 연결된 PC전부 추가
            for(int i : graph[now]){
                if(visited[i]) continue;
                visited[i] = true;
                que.add(i);
            }
        }
        answer = count;
    }

    private static void print() {
        System.out.println(answer);
    }
}