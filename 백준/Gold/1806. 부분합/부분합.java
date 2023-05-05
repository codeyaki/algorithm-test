import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    private static int[] numArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);
        numArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1. 한개씩 수를 합한다
        // 2. 수를 합했을때 S를 넘으면 합이 S를 넘는 것을 유지하면서 왼쪽부터 한개씩 뺸다.
        int sum = 0;
        int left = 0;
        int answer = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            numArr[right] = Integer.parseInt(st.nextToken());
            sum += numArr[right];
            while (sum > s) {
                // s를 넘는 선에서 left를 한개씩 빼준다.
                if (sum - numArr[left] >= s) {
                    sum -= numArr[left++];
                } else {
                    break;
                }
            }
            if (sum >= s) {
                answer = Math.min(answer, right - left + 1);
            }
        }
        if(answer == Integer.MAX_VALUE) answer = 0;
        System.out.println(answer);
    }

}