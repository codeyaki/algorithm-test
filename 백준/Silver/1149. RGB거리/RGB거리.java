import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static private StringBuilder sb = new StringBuilder();
    static private StringTokenizer st;
    static int n;
    static int[][] house;

    public static void main(String[] args) throws IOException {
        read();
        solution();
        close();
    }

    private static void solution() throws IOException {
        house = new int[n + 1][3]; // 빨, 초, 파
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            //빨강
            house[i][0] = Integer.parseInt(st.nextToken()) + Math.min(house[i - 1][1], house[i - 1][2]);
            //초록
            house[i][1] = Integer.parseInt(st.nextToken()) + Math.min(house[i - 1][0], house[i - 1][2]);
            //파랑
            house[i][2] = Integer.parseInt(st.nextToken()) + Math.min(house[i - 1][0], house[i - 1][1]);
        }
        int minResult = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            minResult = Math.min(minResult, house[n][i]);
        }
        sb.append(minResult);
    }

    private static void close() throws IOException {
        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void read() throws IOException {
        n = Integer.parseInt(br.readLine());
    }
}