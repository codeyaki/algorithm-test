import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static int n, m, cntRotation;
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        read();
        for (int i = 0; i < cntRotation; i++) {
            rotation();
        }
        print();
        close();
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

    private static void rotation() {
        int[][] result = new int[n][m];
        int middleN = Math.round(n / 2);
        int middleM = Math.round(m / 2);
        // 왼쪽으로 이동
        for (int i = 0; i < middleN; i++) {
            for (int j = i; j < m - i -1; j++) {
                result[i][j] = arr[i][j + 1];
            }
        }
        // 아래로 이동
        for (int j = 0; j < middleM; j++) {
            for (int i = j + 1; i < n - j; i++) {
                result[i][j] = arr[i - 1][j];
            }
        }
        // 오른쪽으로 이동
        for (int i = middleN; i<n;i++) {
            for (int j = n - i; j < m - (n - i) + 1; j++) {
                result[i][j] = arr[i][j - 1];
            }
        }
        // 위로 이동
        for (int j = middleM; j < m; j++) {
            for (int i = m - j - 1; i < n - (m - j); i++) {
                result[i][j] = arr[i  + 1][j];
            }
        }

        arr = result;


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