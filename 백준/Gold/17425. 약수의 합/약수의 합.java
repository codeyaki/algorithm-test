import java.io.*;
import java.util.Arrays;

public class Main {
    static final int COUNT_N = 1000000 + 1; // 0 ~ 1000000의 개수
    // 입출력을 위한 객체
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // DP를 위한 캐시
    static private long[] fx = new long[COUNT_N]; // N의 약수의 합
    static private long[] gx = new long[COUNT_N]; // N까지 모든 약수의 합

    public static void main(String[] args) throws IOException {
        solution();
        printResult(Integer.parseInt(br.readLine()));
    }

    private static void solution() {
        // 계산을 위한 g(0) 초기화
        gx[0] = 0L;
        gx[1] = 1L;
        for (int i = 1; i < COUNT_N; i++) {
            for (int j = i; j < COUNT_N; j += i) {
                fx[j] += i;
            }
            gx[i] = gx[i - 1] + fx[i]; // g(n) = g(n-1) + f(n)
        }
    }

    private static void printResult(int countTestcase) throws IOException {
        for (int testcase = 0; testcase < countTestcase; testcase++) {
            int n = Integer.parseInt(br.readLine());
            bw.append(gx[n] + "\n");
        }
        bw.flush();
    }
}
