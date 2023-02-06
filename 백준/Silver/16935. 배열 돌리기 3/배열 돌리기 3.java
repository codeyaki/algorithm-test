import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static private StringBuilder sb = new StringBuilder();
    static private StringTokenizer st;
    static int n, m, cntOp;
    static int[] op;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        read();
        solution();
        close();
    }

    private static void solution() throws IOException {
        for (int i = 0; i < cntOp; i++) {
            switch (st.nextToken()) {
                // 상하 반전
                case "1":
                    reverseY();
                    break;
                // 좌우 반전
                case "2":
                    reverseX();
                    break;
                // 오른쪽 90도
                case "3":
                    rotationR();
                    break;
                // 왼쪽 90도
                case "4":
                    rotationL();
                    break;
                // 사분면 오른쪽 90도 회전
                case "5":
                    rotationQuadrantR();
                    break;
                // 1->4, 4->3, 3->2, 2->1
                case "6":
                    rotationQuadrantL();
                    break;
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }

    }

    private static void rotationQuadrantL() {
        // 사분면 왼쪽 90도 회전
        int[][] tmp = new int[n][m];
        int middleY = n / 2;
        int middleX = m / 2;
        // 1사분면 -> 2사분면
        for (int i = 0; i < middleY; i++) {
            for (int j = middleX; j < m; j++) {
                tmp[i][j - middleX] = arr[i][j];
            }
        }
        // 2사분면 -> 3사분면
        for (int i = 0; i < middleY; i++) {
            for (int j = 0; j < middleX; j++) {
                tmp[i + middleY][j] = arr[i][j];
            }
        }
        // 3사분면 -> 4사분면
        for (int i = middleY; i < n; i++) {
            for (int j = 0; j < middleX; j++) {
                tmp[i][j + middleX] = arr[i][j];
            }
        }
        // 4사분면 -> 1사분면
        for (int i = middleY; i < n; i++) {
            for (int j = middleX; j < m; j++) {
                tmp[i - middleY][j] = arr[i][j];
            }
        }
        arr = tmp;
    }

    private static void rotationQuadrantR() {
        // 사분면 오른쪽 90도 회전
        int[][] tmp = new int[n][m];
        int middleY = n / 2;
        int middleX = m / 2;
        // 1사분면 -> 4사분면
        for (int i = 0; i < middleY; i++) {
            for (int j = middleX; j < m; j++) {
                tmp[i + middleY][j] = arr[i][j];
            }
        }
        // 2사분면 -> 1사분면
        for (int i = 0; i < middleY; i++) {
            for (int j = 0; j < middleX; j++) {
                tmp[i][j + middleX] = arr[i][j];
            }
        }
        // 3사분면 -> 2사분면
        for (int i = middleY; i < n; i++) {
            for (int j = 0; j < middleX; j++) {
                tmp[i - middleY][j] = arr[i][j];
            }
        }
        // 4사분면 -> 3사분면
        for (int i = middleY; i < n; i++) {
            for (int j = middleX; j < m; j++) {
                tmp[i][j - middleX] = arr[i][j];
            }
        }
        arr = tmp;
    }

    private static void rotationL() {
        // 왼쪽으로 90도 회전
        int[][] tmp = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[m - j - 1][i] = arr[i][j];
            }
        }
        arr = tmp;
        int t = n;
        n = m;
        m = t;
    }

    private static void rotationR() {
        // 오른쪽으로 90도 회전
        int[][] tmp = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[j][n - i - 1] = arr[i][j];
            }
        }
        int t = n;
        n = m;
        m = t;
        arr = tmp;
    }

    private static void reverseY() {
        // 상하 반전
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[n - i - 1][j] = arr[i][j];
            }
        }
        arr = tmp;
    }

    private static void reverseX() {
        // 좌우 반전
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][m - j - 1] = arr[i][j];
            }
        }
        arr = tmp;
    }


    private static void close() throws IOException {
        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void read() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cntOp = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 연산자들이 담겨있음
        st = new StringTokenizer(br.readLine());
    }
}