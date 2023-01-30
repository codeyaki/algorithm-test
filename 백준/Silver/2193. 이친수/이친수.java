import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int MAX = 90 + 1;
    static long[][] cache = new long[MAX + 1][2];
    // 새로운 자리에 0, 1이 저장되는 경우를 각각 저장

    public static void main(String[] args) throws IOException {
        dp();
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        for (int i = 0; i < 2; i++) {
            sum = (sum + cache[n][i]);
        }
        sb.append(sum);
        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dp() {
        // 초기화
        cache[1][1] = 1; // 1
        cache[2][0] = 1; // 10
        cache[3][1] = 1; // 101
        cache[3][0] = 1; // 100

        for (int i = 4; i < MAX; i++) {
            cache[i][0] = cache[i - 1][0] + cache[i - 1][1];// 0을 추가할 수 있는 경우는 전의 자리가 0 혹은 1이 오는 경우 가능
            cache[i][1] = cache[i - 1][0]; // 1을 추가할 수 있는 경우는 전의 자리에 0이 온경우만 가능
        }


    }

}