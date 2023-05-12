import java.io.*;
import java.util.*;

public class Main{

    private static int[] selectNums;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int t = 0; t < testCase; t++){
            int n = Integer.parseInt(br.readLine()) + 1; // 편의를 위해 0추가 
            selectNums = new int[n];
            String[] line = br.readLine().split(" ");
            for(int i = 1; i < n; i++){
                selectNums[i] = Integer.parseInt(line[i - 1]);
            }
            int answer = solution(n);
            System.out.println(answer);
        }
    }

    private static boolean[] visited, isDone;
    private static int teamCount;

    
    private static int solution(int n){
        visited = new boolean[n];
        isDone = new boolean[n];
        teamCount = 0;
        // 한개씩 dfs를 통해서 싸이클이 형성되어 있는지 확인
        for(int i = 0; i < n; i++){
            dfs(i);
        }
        // 팀으로 형성된 애들은 전체 인원에서 빼면 팀이 형성되지 않은 애들
        return n - teamCount;
    }

    private static void dfs(int now){
        // 이미 팀 형성이 완료된 경우 더 확인할 필요 없음
        if(isDone[now]) return;
        if(visited[now]) {
            isDone[now] = true;
            teamCount++;
        }
        int select = selectNums[now];
        // 만약 고른 사람이 이미 팀이라면? 이사람도 사이클 안에 포함되어 있다는 것.
        if(isDone[select]) return;
        // 이미 팀으로 형성된 사람은 아니지만 이미 골랐던 팀이라면? 
        visited[now] = true;
        dfs(select);
        // 팀으로 형성되지 못한 애들도 검사 끝
        isDone[now] = true;
        visited[now] = false;
    }
}
