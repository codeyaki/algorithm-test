import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        /*
         * 입력
         * 첫째 줄에 N(1 ≤ N ≤ 100,000,000)이 주어진다.
         * */
        long n = Integer.parseInt(br.readLine());
        // 각 자리수별로 몇개까지 되는지 확인
        int digit = calcDigitNewNumber(n);
        bw.append(String.valueOf(digit));
        bw.flush();
        bw.close();
        br.close();

    }

    private static int calcDigitNewNumber(long n) {
        // 각 자리수별로 확인
        // 0~9 : 1개 * 10개, 10~99 : 2개 * 90개, 100~999: 9000개 ...
        //
        int result = 0;
        int countDigit = 1;
        long number = n;
        while (number >= 10) {
            result += ((Math.pow(10, countDigit)) - (Math.pow(10, (countDigit - 1)))) * countDigit;
            countDigit++;
            number /= 10;
        }
        result += (n - (Math.pow(10, countDigit -1)) + 1) * countDigit;
        return result;
    }
}
