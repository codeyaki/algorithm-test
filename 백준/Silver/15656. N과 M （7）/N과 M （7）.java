import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] numList;
    private static List<Integer> seqList = new ArrayList<>();
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // 입력과 동시에 정렬
        numList = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
        // dfs 돌리기
        dfs(0, 0);

        // 출력
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int point, int length) throws IOException {
        if (length >= m) {
            for (int num : seqList) {
                bw.append(String.valueOf(num)).append(" ");
            }
            bw.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            seqList.add(numList[i]);
            dfs(i, length + 1);
            seqList.remove(length);
        }
    }
}
