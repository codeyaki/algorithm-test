import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int MAX = 1000000;
    static int[] cache = new int[MAX + 1];
    public static void main(String[] args) throws IOException {
        dp();
        int num = Integer.parseInt(br.readLine());
        System.out.println(cache[num]);
    }

    private static void dp() {
        for (int i = 2; i < MAX + 1; i++) {
            int result = i % 3 == 0 ? cache[i / 3] + 1 : Integer.MAX_VALUE;
            result = Math.min(result, i % 2 == 0 ? cache[i / 2] + 1 : Integer.MAX_VALUE);
            result = Math.min(result, cache[i - 1] + 1);
            cache[i] = result;
        }
    }

}