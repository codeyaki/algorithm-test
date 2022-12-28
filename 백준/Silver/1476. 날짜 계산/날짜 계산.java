import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int MAX = 15 * 28 * 19;

    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int result = calcDate(a, b, c);
        bw.append(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int calcDate(int a, int b, int c) {
        for (int i = 1; i < MAX +1; i++) {
            if ((i - a) % 15 == 0 && (i - b) % 28 == 0 && (i - c) % 19 == 0) {
                return i;
            }
        }
        return 0;
    }
}
