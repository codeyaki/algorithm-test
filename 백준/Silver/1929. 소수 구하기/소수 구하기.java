import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int COUNT_NUMBER = 1000000;
    private static boolean[] notPrimeNumberList = new boolean[COUNT_NUMBER];
    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        eratosthenes(m, n);
        bw.flush();
    }

    private static void eratosthenes(int m, int n) throws IOException {
        notPrimeNumberList[0] = notPrimeNumberList[1] = true;
        for (int i = 2; i < COUNT_NUMBER; i++) {
            if (!notPrimeNumberList[i]) {
                for (int j = i * 2; j < COUNT_NUMBER; j += i) {
                    notPrimeNumberList[j] = true;
                }
                if (m <= i && i <= n) {
                    bw.append(String.valueOf(i)).append("\n");
                }
            }
        }
    }
}
