import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine().trim());
        // 입력
        /*
         * 각 테스트 데이터는 한 줄로 구성된다.
         * 각 줄에는 네 개의 정수 M, N, x와 y가 주어진다.
         * (1 ≤ M, N ≤ 40,000, 1 ≤ x ≤ M, 1 ≤ y ≤ N)
         * 여기서 <M:N>은 카잉 달력의 마지막 해를 나타낸다.
         *  */
        for (int i = 0; i < t; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.append(String.valueOf(calcDate(m, n, x, y))).append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int calcDate(int m, int n, int x, int y) throws IOException {
        // x가 올수있는 년도만 확인하면 범위를 줄일 수 있다.
        // date = M*i + x;
        for (int date = x; date <= m * n; date += m) {
            if ((date - 1) % n + 1 == y) {
                return date;
            }
        }
        return -1;
    }

}
