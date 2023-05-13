import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        Solution solution = new Solution(str1, str2);
        System.out.println(solution.getLcsLength());
        System.out.println(solution.getLcsString());
    }
}

class Solution {
    String str1, str2;
    int n, m;
    int[][] lcs;

    public Solution(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        this.n = str1.length();
        this.m = str2.length();
        this.lcs = new int[str1.length() + 1][str2.length() + 1];
        dp();
    }

    private void dp() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 같은 경우 저장된 최장 수열 + 1
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
                // System.out.print(lcs[i][j] + " ");
            }
            // System.out.println("");
        }
    }

    public int getLcsLength() {
        return this.lcs[n][m];
    }

    public String getLcsString(){
        StringBuilder result = new StringBuilder();
        int i = n, j = m;
        while(lcs[i][j] > 0 && i > 0 && j > 0){
            // 위나 왼쪽에 같은 수가 있는지 확인 (있다면 이동)
            if(lcs[i-1][j] == lcs[i][j]){
                i--;
                continue;
            }
            else if (lcs[i][j-1] == lcs[i][j]){
                j--;
                continue;
            }
            else{
                result.insert(0, str1.charAt(i-1));
                i--;
                j--;
            }
        }
        return result.toString();
    }
}