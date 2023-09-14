import java.util.*;

class Solution {
    List<Integer>[] graph;
    final int MAX_COUNT = 100 + 1;
    public int solution(int n, int[][] wires) {
        int[] minWire = new int[]{0, Integer.MAX_VALUE};
        // 전선 한개씩 빼면서 개수 확인
        for(int i = 0; i < wires.length; i++){
            init(wires, i);
            int count1 = countNode(wires[i][0]);
            int count2 = countNode(wires[i][1]);
            int diff = Math.abs(count1 - count2);
            if(minWire[1] > diff) minWire = new int[]{i, diff};
        }
        return minWire[1];
    }
    
    private void init(int[][] wires, int exceptWire){
        graph = new List[MAX_COUNT];
        for(int i = 0; i < MAX_COUNT; i++){
          graph[i] = new LinkedList<>();  
        };
        for(int i = 0; i < wires.length; i++){
            if(i == exceptWire) continue;
            int node1 = wires[i][0];
            int node2 = wires[i][1];
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
    }
    
    private int countNode(int start){
        boolean[] visited = new boolean[MAX_COUNT];
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        int count = 0;
        while(!que.isEmpty()){
            int now = que.poll();
            count++;
            for(int next : graph[now]){
                if(visited[next]) continue;
                visited[next] = true;
                que.add(next);
            }
        }
        return count;
    }
}