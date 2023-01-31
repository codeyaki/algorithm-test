import com.sun.jdi.ArrayReference;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int[] cache, leng, numsArr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        cache = new int[n + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        leng = new int[n + 1];
        numsArr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxIndex = 0;
        for (int i = 1; i < n + 1; i++) {
            numsArr[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < n + 1; j++) {
                if (cache[j] >= numsArr[i]) {
                    leng[i] = j;
                    cache[j] = numsArr[i];
                    maxIndex = Math.max(j, maxIndex);
                    break;
                }
            }
        }

        Stack<Integer> result = new Stack<>();
        sb.append(maxIndex).append("\n");
        for (int i = n; i > 0; i--) {
            if (leng[i] == maxIndex) {
                maxIndex--;
                result.push(numsArr[i]);
            }
        }
        while (!result.isEmpty()) {
            sb.append(result.pop()).append(" ");
        }
        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}