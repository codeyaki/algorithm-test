import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int target;
    private static int[] brokenButtonList;
    private static final int MAX = 500000;

    public static void main(String[] args) throws IOException {
        input();
        int result = solution();
        bw.append(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void input() throws IOException {
        target = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());
        brokenButtonList = new int[n];
        if (n > 0) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int i = 0; i < n; i++) {
                brokenButtonList[i] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int solution() {
        int result = 999999;
        // 정답부터 바로 버튼으로 만들 수 있는 지 확인
        for (int i = 0; i <= 999999; i++) {
            // 음수 (0 보다 낮아질 수 없음)
            // 더해서 자리수가 올라가는 경우에는 누르는 횟수가 1개 추가되기때문에 음수먼저 확인
            int checkedNumber = target - i;
            if ((checkedNumber >= 0) && !checkContainBrokenButton(checkedNumber)) {
                // 고장난 버튼이 포함되어 있지 않는 경우
                result = String.valueOf(checkedNumber).length() + i;
                break;
            }
            // 양수 (채널 무한대)
            checkedNumber = target + i;
            if (!checkContainBrokenButton(checkedNumber)) {
                // 고장난 버튼이 포함되어 있지 않는 경우
                result = String.valueOf(checkedNumber).length() + i;
                break;
            }
        }
        result = Math.min((Math.abs(target - 100)), result);
        return result;
    }

    private static boolean checkContainBrokenButton(int number) {
        if (number == 0) {
            for (int brokenButton : brokenButtonList) {
                // 고장난 버튼이 있는 경우 true
                if (number == brokenButton) {
                    return true;
                }
            }
        }
        while (number > 0) {
            int unit = number % 10;
            number /= 10;
            // 각 자리수에 고장난 버튼이 포함되어 있는지 확인
            for (int brokenButton : brokenButtonList) {
                // 고장난 버튼이 있는 경우 true
                if (unit == brokenButton) {
                    return true;
                }
            }
        }
        // 끝까지 확인했는데 고장난 버튼이 없는 경우
        return false;
    }

}
