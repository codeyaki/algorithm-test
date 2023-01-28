import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int MAX = 1000 + 1;
    static int[] cache = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        dp();
        int num = Integer.parseInt(br.readLine());
        System.out.println(cache[num]);
    }

    private static void dp() {
        cache[1] = 1;
        cache[2] = 3;
        for (int i = 3; i < MAX; i++) {
            cache[i] = (cache[i - 2] + cache[i - 1] + cache[i - 2]) % 10007;
        }
    }

}