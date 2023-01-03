import java.io.*;
import java.util.Arrays;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int numList[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += Math.pow(numList[i], 2);
        }
        bw.append(String.valueOf(sum % 10));
        bw.flush();
        bw.close();
        br.close();
    }
}
