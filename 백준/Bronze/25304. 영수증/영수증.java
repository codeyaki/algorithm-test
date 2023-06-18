import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    static String[][] cave;
    static int[] throwList;
    static int[][] cluster;
    
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int expectedTotal = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int total = 0;
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            int price = Integer.parseInt(line[0]);
            int cnt = Integer.parseInt(line[1]);
            total += price * cnt;
        }
        String answer = expectedTotal == total ? "Yes" : "No";
        System.out.println(answer);
    }
    
}
