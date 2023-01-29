import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int MAX = 100000;
    static int[][] cache = new int[MAX + 1][3 + 1];
    // 마지막자리가 +1, +2, +3을 한것을 각각 저장

    public static void main(String[] args) throws IOException {
        dp();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int j = 1; j < 4; j++) {
                sum = (sum + cache[num][j]) % 1000000009;
            }
            sb.append(sum).append("\n");
        }
        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dp() {
        cache[1][1] = 1;
        cache[2][2] = 1;
        cache[3][1] = 1;
        cache[3][2] = 1;
        cache[3][3] = 1;
        for (int i = 4; i < MAX + 1; i++) {
            // 이번 회차에 +1을 하는 경우
            cache[i][1] = (cache[i - 1][2] + cache[i - 1][3]) % 1000000009;
            // 이번 회차에 +2를 하는 경우
            cache[i][2] = (cache[i - 2][1] + cache[i - 2][3]) % 1000000009;
            // 이번 회차에 +3을 하는 경우
            cache[i][3] = (cache[i - 3][1] + cache[i - 3][2]) % 1000000009;

        }
    }

}