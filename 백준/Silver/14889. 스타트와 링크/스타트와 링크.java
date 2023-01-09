import java.io.*;
import java.util.Arrays;


public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    // 총 인원수
    private static int n;
    // 능력치 저장
    private static int[][] status;
    // 선수 선택 여부 저장
    private static boolean[] selectedArray;
    // 팀 점수 차이가 가장 최소의 경우 차이 저장
    private static int result = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        // 입력
        n = Integer.parseInt(br.readLine().trim());
        status = new int[n][n];
        selectedArray = new boolean[n];
        for (int i = 0; i < n; i++) {
            status[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 풀이
        selectMember(0, 0);
        bw.append(String.valueOf(result));
        // 출력
        bw.flush();
        bw.close();
        br.close();
    }

    private static void selectMember(int index, int count) {
        if (count == n / 2) {
            result = Math.min(result, checkScore());
            return;
        }
        // 팀원 선택
        for (int i = index; i < n; i++) {
            if (!selectedArray[i]) {
                selectedArray[i] = true;
                selectMember(i, count + 1);
                selectedArray[i] = false;
            }
        }
    }

    private static int checkScore() {
        for (boolean b : selectedArray) {
        }
        int team1 = 0;
        int team2 = 0;
        // 한명씩 돌아가면서 각 팀 점수 계산
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 선수 i와 선수 j가 같은 팀인 경우
                if (selectedArray[i] && selectedArray[j]) {
                    team1 += status[i][j] + status[j][i];
                }
                if (!selectedArray[i] && !selectedArray[j]) {
                    team2 += status[i][j] + status[j][i];
                }
            }

        }
        return Math.abs(team1 - team2);
    }

}
