import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            numArr[i] = Integer.parseInt(line[0]);
            if (i == n - 1) {
                numArr[i + 1] = Integer.parseInt(line[1]);
            }
        }
        Solution solution = new Solution(numArr, n);
        System.out.println(solution.getAnswer());



    }
}

class Solution {
    int[][] cache;
    int[] numArr;
    int n;

    public Solution(int[] numArr, int n) {
        this.numArr = numArr;
        this.n = n;
        cache = new int[n][n];
    }
    public int getAnswer(){
        // i ~ i + 1까지 구하기
        for(int i = 0; i < n - 1; i++){
            cache[i][i+1] = numArr[i] * numArr[i+1] * numArr[i+2];
        }
        for(int start = 2; start < n; start++){
            // 대각선
            for(int i = 0; i + start < n; i++){
                int j = i + start;
                cache[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    cache[i][j] = Math.min(cache[i][j], cache[i][k] + cache[k + 1][j] + (numArr[i] * numArr[k + 1] * numArr[j + 1]));
                }
            }
        }
        return cache[0][n-1];
    }
}