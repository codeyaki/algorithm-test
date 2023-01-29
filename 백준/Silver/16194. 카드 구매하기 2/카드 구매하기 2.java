import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int MAX = 1000;
    static int[] cache = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cache[i] = Integer.parseInt(st.nextToken());
            for (int j = i; j >= i / 2; j--) {
                cache[i] = Math.min(cache[i], cache[j] + cache[i - j]);
            }
        }
        sb.append(cache[n]);
        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}