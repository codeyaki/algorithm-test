import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int[][] stickers;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int TestCase = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int t = 0; t < TestCase; t++) {
            int n = Integer.parseInt(br.readLine());
            stickers = new int[2][n];
            // 2 * n
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for (int col = 0; col < n; col++) {
                stickers[0][col] = Integer.parseInt(st1.nextToken());
                stickers[1][col] = Integer.parseInt(st2.nextToken());
            }
            // 풀이
            int result = solution(n);
            answer.append(result).append("\n");
        }

        // 출력
        br.close();
        System.out.println(answer.toString());
    }

    private static int solution(int n) {
        // i에서 해당 스티커를 골랐을 경우의 최대 값 구하기
        int[][] cache = new int[2][n + 1];
        cache[0][1] = stickers[0][0];
        cache[1][1] = stickers[1][0];
        for (int i = 2; i <= n; i++) {
            cache[0][i] = stickers[0][i-1] + Math.max(cache[1][i - 1], cache[1][i - 2]);
            cache[1][i] = stickers[1][i-1] + Math.max(cache[0][i - 1], cache[0][i - 2]);
        }
        return Math.max(cache[0][n], cache[1][n]);
    }

}