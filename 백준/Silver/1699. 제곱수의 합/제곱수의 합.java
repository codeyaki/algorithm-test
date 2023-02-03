import java.io.*;

public class Main {
    static private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static private int n;
    static private final int MAX = 100000 + 1;
    static private int[] cache = new int[MAX];
    public static void main(String[] args) throws IOException {
        read();
        dp();
        print();
    }

    private static void dp() throws IOException {
        cache[1] = 1;
        for (int i = 2; i < MAX; i++) {
            cache[i] = Integer.MAX_VALUE;
            for (int j = 1; (j * j) <= i; j++) {
                cache[i] = Math.min(cache[i - (j * j)] + 1, cache[i]);
            }
        }
        bw.append(String.valueOf(cache[n]));
    }

    private static void print() throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }

    private static void read() throws IOException {
        n = Integer.parseInt(br.readLine());
    }
}