import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static private int n, k;
    static private final int MAX = 200 + 1;
    static private int[][] cache = new int[MAX][MAX];
    public static void main(String[] args) throws IOException {
        read();
        dp();
        print();
    }

    private static void dp() throws IOException {
        // 1개를 선택하는 경우는 한가지 경우 밖에없음
        for (int j = 0; j < MAX; j++) {
            cache[1][j] = 1;
        }
        // 2개부턴 계산
        for (int i = 2; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                // i-1 에서 +k를 해서 n이되는 경우들의 합 => i-1에서 j-k의 위치
                for (int k = 0; k <= j; k++) {
                    cache[i][j] = (cache[i][j] + cache[i - 1][j - k]) % 1000000000;
                }
            }
        }
        bw.append(String.valueOf(cache[k][n]));
    }

    private static void print() throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }

    private static void read() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    }
}