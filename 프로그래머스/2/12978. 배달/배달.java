import java.util.*;

class Solution {
    private List<Node>[] graph;
    public int solution(int N, int[][] road, int K) {
        init(N + 1, road);
        return dijkstra(1, N + 1, K);
    }
    
    private int dijkstra(int start, int n, int k){
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        boolean[] isVisited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(isVisited[now.next]) continue;
            isVisited[now.next] = true;
            for(Node nextNode : graph[now.next]) {
                if(distance[nextNode.next] > now.cost + nextNode.cost) {
                    distance[nextNode.next] = now.cost + nextNode.cost;
                    pq.add(new Node(nextNode.next, distance[nextNode.next]));
                }
            }
        }
        int result = 0;
        for(int i = 1; i < n; i++) {
            if(distance[i] <= k) result++;
        }
        return result;
    }
    
    private void init(int n, int[][] road) {
        graph = new List[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] r : road) {
            int city1 = r[0];
            int city2 = r[1];
            int cost = r[2];
            graph[city1].add(new Node(city2, cost));
            graph[city2].add(new Node(city1, cost));
        }
    }
    
    
    class Node{
        int next;
        int cost;
        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
        
        public String toString(){
            return "{" + next + ", " + cost + "}";
        
        }
    }
    
    
}