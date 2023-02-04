import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.logging.Level;

public class Main {
    static private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static private StringBuilder sb = new StringBuilder();
    static private StringTokenizer st;
    static int n;
    static int[] line;

    public static void main(String[] args) throws IOException {
        read();
        solution();
        close();
    }

    private static void solution() {
        line = new int[n];
        for (int i = 0; i < n; i++) {
            // 해당 차례의 사람이 뽑은 번호
            // 1을 뽑으면 한자리 앞으로 , n을 뽑으면 n만큼 앞으로
            int drawing = Integer.parseInt(st.nextToken());
            // 새로 들어온 사람의 자리에따라 밀려나야함
            for (int j = i; j > i - drawing; j--) {
                line[j] = line[j - 1];
            }
            // 공백이 생긴 자리에 새로운 사람이 들어가기
            line[i - drawing] = i + 1;
        }

        for (int i = 0; i < n; i++) {
            sb.append(line[i]).append(" ");
        }

    }

    private static void close() throws IOException {
        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void read() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
    }
}