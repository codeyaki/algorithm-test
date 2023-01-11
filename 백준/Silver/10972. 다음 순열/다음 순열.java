import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static int[] numArray;

    public static void main(String[] args) throws IOException {
        // 입력
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numArray = new int[n];
        for (int i = 0; i < n; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }
        // 풀이
        solution();
        // 출력
        for (int i : numArray) {
            bw.append(String.valueOf(i)).append(" ");

        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void solution() {
        int left = n - 1;
        int right = n - 1;
        // 왼쪽 찾기
        while (left > 0 && numArray[left - 1] >= numArray[left]) left--;
        // left가 -1인경우 이미 최대 수열임
        if (left <= 0) {
            numArray = new int[]{-1};
            return;
        }
        // 오른쪽 찾기
        while (numArray[right] <= numArray[left - 1]) right--;
        // left -1 과 right 교체
        swap(left - 1, right);
        // left 이상 수열 뒤집기
        right = n - 1;
        while (left < right) {
            swap(left, right);
            left++;
            right--;
        }

    }

    private static void swap(int a, int b) {
        int tmp = numArray[a];
        numArray[a] = numArray[b];
        numArray[b] = tmp;
    }

}
