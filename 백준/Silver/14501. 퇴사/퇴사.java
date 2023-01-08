import java.io.*;
import java.util.StringTokenizer;


public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 소요일
    private static int[] dateList;
    // 수입
    private static int[] incomeList;
    // 최대 수입
    private static int maxIncome = 0;

    public static void main(String[] args) throws IOException {
        // 입력
        int n = Integer.parseInt(br.readLine().trim());
        dateList = new int[n];
        incomeList = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dateList[i] = Integer.parseInt(st.nextToken());
            incomeList[i] = Integer.parseInt(st.nextToken());
        }
        // 풀이
        /*
         * 맨 뒤부터 해당 일자에 상담을 했을 경우 / 안했을 경우의 베스트를 저장
         */
        int[] cache = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            cache[i] = 0;
            int case1 = 0;
            // 해당일자의 상담이 가능한 경우
            if (i + dateList[i] <= n) {
                case1 += incomeList[i];
                // 종료 후 추가 상담이 가능하면 하는 것이 최대 값이다.
                if (i + dateList[i] < n) {
                    case1 += cache[i+dateList[i]];
                }
            }
            // 해당 일자에 상담을 하지 않았을 경우
            int case2 = 0;
            // 다음날이 있는지 판별
            if (i + 1 < n) {
                case2 += cache[i + 1];
            }
            // 두 경우를 비교해서 가장 높은 수익 저장
            cache[i] = Math.max(case1, case2);
            maxIncome = Math.max(cache[i], maxIncome);
        }
        bw.append(String.valueOf(maxIncome));
        // 출력
        bw.flush();
        bw.close();
        br.close();
    }

}
