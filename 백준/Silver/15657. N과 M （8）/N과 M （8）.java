import java.io.*;
import java.util.*;

class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n, m;
    private static int[] arr, answer;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        answer = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int now, int length) throws IOException {
        if(length >= m){
            bw.append(getStringArr()).append("\n");
            return;
        }
        for(int i = now; i < n; i++){
            answer[length] = arr[i];
            dfs(i, length + 1);
        }
    }
    private static String getStringArr(){
        StringBuffer sb = new StringBuffer();
        for(int s : answer){
            sb.append(s).append(" ");
        }
        return sb.toString();
    }
}