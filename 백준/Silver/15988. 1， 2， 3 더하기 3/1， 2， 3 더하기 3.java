import java.io.*;

public class Main {
    static private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static private StringBuilder sb = new StringBuilder();

    static int n, MAX = 1000000 + 1;
    static int[] cache = new int[MAX];

    public static void main(String[] args) throws IOException {
        read();
        dp();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(cache[num]).append("\n");
        }
        bw.append(sb.toString());
        close();
    }

    private static void dp() {
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 4;
        for (int i = 4; i < MAX; i++) {
            cache[i] = ((cache[i - 1] + cache[i - 2]) % 1000000009 + cache[i - 3]) % 1000000009;
        }
    }


    private static void close() throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }

    private static void read() throws IOException {
        n = Integer.parseInt(br.readLine());
    }
}