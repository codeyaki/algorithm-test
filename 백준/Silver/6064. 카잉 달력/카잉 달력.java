import javax.xml.stream.FactoryConfigurationError;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        // 입력
        /*
         * 각 테스트 데이터는 한 줄로 구성된다.
         * 각 줄에는 네 개의 정수 M, N, x와 y가 주어진다.
         * (1 ≤ M, N ≤ 40,000, 1 ≤ x ≤ M, 1 ≤ y ≤ N)
         * 여기서 <M:N>은 카잉 달력의 마지막 해를 나타낸다.
         *  */
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int gcd = gcd(Math.max(M, N), Math.min(M, N));
            int lcm = (M * N / gcd);
            // x가 올수있는 년도만 확인하면 범위를 줄일 수 있다.
            // date = M*i + x;
            boolean isbreak = false;
            for (int date = x; date <= lcm; date += M) {
                if ((date - 1) % N + 1 == y) {
                    bw.append(String.valueOf(date)).append("\n");
                    isbreak = true;
                    break;
                }
            }
            if (!isbreak) {
                bw.append("-1").append("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int gcd(int m, int n) {
        if (m % n == 0) {
            return n;
        }
        return gcd(n, m % n);
    }


}
