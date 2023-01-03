import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static int n, m;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> numList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int[] numList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = numList[0];
        m = numList[1];
        dfs(0, 0);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int point, int length) throws IOException {
        if (length >= m ) {
            for (Integer num : numList) {
                bw.append(String.valueOf(num)).append(" ");
            }
            bw.append("\n");
            return;
        }
        for (int i = 0; i < n ; i++) {
            numList.add(i + 1);
            dfs(i + 1, length + 1);
            numList.remove(numList.size() - 1);
        }

    }
}
