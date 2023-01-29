import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int MAX = 100;
    static int[][] cache = new int[MAX + 1][9 + 1];
    // 마지막자리가 +1, +2, +3을 한것을 각각 저장

    public static void main(String[] args) throws IOException {
        dp();
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum = (sum + cache[n][i]) % 1000000000;
        }
        sb.append(sum);
        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dp() {
        // 초기화
        for (int i = 0; i < 10; i++) {
            cache[1][i] = 1;
        }

        for (int i = 2; i < MAX + 1; i++) {
            // 뒷부분에 0을 더하는 경우는 이전 수의 끝이 1인 경우만 가능
            cache[i][0] = cache[i - 1][1];
            // 1~8을 추가하는 경우 -1 / +1 경우 가능
            for (int j = 1; j < 9; j++) {
                cache[i][j] = (cache[i - 1][j - 1] + cache[i - 1][j + 1]) % 1000000000;
            }
            // 9를 추가하는 경우 이전 수의 끝이 8인 경우만 가능
            cache[i][9] = cache[i - 1][8];
        }

    }

}