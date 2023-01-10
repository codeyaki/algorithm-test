import java.io.*;
import java.util.StringTokenizer;


public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    // 총 인원수
    private static int n;
    // 가로 합
    private static int[] sumRow;
    // 세로 합
    private static int[] sumColumn;
    // 답 출력용 변수
    private static int result = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        // 입력
        n = Integer.parseInt(br.readLine().trim());
        sumRow = new int[n];
        sumColumn = new int[n];
        int sumTotal = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                sumTotal += num;
                sumRow[i] += num;
                sumColumn[j] += num;
            }
        }

        // 풀이
        selectMember(0, 0, sumTotal);
        bw.append(String.valueOf(result));

        // 출력
        bw.flush();
        bw.close();
        br.close();
    }

    private static void selectMember(int index, int count, int sumTotal) {
        result = Math.min(result, Math.abs(sumTotal));

        //index에 도달했을 경우
        if (index == n) {
            return;
        }
        // 해당 index에서는 두가지의 경우의 수가 있음
        // 해당 멤버를 선택하는 경우
        selectMember(index + 1, count + 1, sumTotal - sumRow[index] - sumColumn[index]);
        // 해당 멤버를 선택하지 않는 경우
        selectMember(index + 1, count, sumTotal);
    }


}
