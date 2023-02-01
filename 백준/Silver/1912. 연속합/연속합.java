import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] cache;


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        cache = new int[n];
        cache[0] = Integer.parseInt(st.nextToken());
        int max = cache[0];
        for (int i = 1; i < n; i++) {
            int newNum = Integer.parseInt(st.nextToken());
            cache[i] = Math.max(cache[i - 1] + newNum, newNum);

            max = Math.max(cache[i], max);
        }
        System.out.println(max);

    }

}