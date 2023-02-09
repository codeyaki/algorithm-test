import java.io.*;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static int n, m;
    static int cntRotation;
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        read();
        int lenN = n - 1;
        int lenM = m - 1;
        for (int i = 0; i < Math.round(Math.min(m, n) / 2); i++) {
            // 시작점은 i,i 부터 한바퀴 돌기
            rotation(i, (lenN + lenM) * 2);
            lenN -= 2;
            lenM -= 2;
        }

        print();
        close();
    }

    private static void rotation(int startPoint, int totalCnt) {
        // 회전수 만큼 이동하기
        int cnt = cntRotation % totalCnt;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (cnt-- > 0) {
            int index = 0;
            int x = startPoint;
            int y = startPoint;
            // 한바퀴 돌기
            int tmp = arr[startPoint][startPoint];
            while (index < 4) {
                int nextX = x + dx[index];
                int nextY = y + dy[index];
                if (nextX >= startPoint && nextY >= startPoint && nextX < m - startPoint && nextY < n - startPoint) {
                    arr[y][x] = arr[nextY][nextX];
                    x = nextX;
                    y = nextY;
                } else {
                    index++;
                }
            }
            arr[startPoint + 1][startPoint] = tmp;

        }

    }

    private static void close() throws IOException {
        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    private static void read() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cntRotation = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }



}