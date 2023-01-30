import java.io.*;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int[] cache;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        cache = new int[n];
        Arrays.fill(cache, Integer.MAX_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                if (cache[j] >= num) {
                    cache[j] = num;
                    break;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (cache[i] != Integer.MAX_VALUE) result++;
        }
        sb.append(result);
        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dp() {

    }

}