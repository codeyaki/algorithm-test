import java.io.*;
import java.util.StringTokenizer;


public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static char[] inequality;
    private static boolean[] visitedArray = new boolean[10];
    private static long maxNum = Long.MIN_VALUE;
    private static long minNum = Long.MAX_VALUE;

    private static long result = 0;

    public static void main(String[] args) throws IOException {
        // 입력
        n = Integer.parseInt(br.readLine().trim());
        inequality = new char[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        inequality[0] = '<';
        for (int i = 1; i < n + 1; i++) {
            inequality[i] = st.nextToken().charAt(0);
        }
        // 풀이
        makeNumber(0, 0);
        bw.append(String.valueOf(String.format("%0"+(n+1)+"d",maxNum))).append("\n");
        bw.append(String.valueOf(String.format("%0"+(n+1)+"d",minNum))).append("\n");

        // 출력
        bw.flush();
        bw.close();
        br.close();
    }

    private static void makeNumber(int number, int length) throws IOException {
        if (length == n + 1) {
            maxNum = Math.max(maxNum, result);
            minNum = Math.min(minNum, result);
            return;
        }

        for (int i = number; (0 <= i && i < 10); i += (inequality[length] == '>' ? -1 : +1)) {
            if (visitedArray[i]) {
                continue;
            }
            visitedArray[i] = true;
            result = (result * 10) + i;
            makeNumber(i, length + 1);
            result = result / 10;
            visitedArray[i] = false;
        }
    }
}
