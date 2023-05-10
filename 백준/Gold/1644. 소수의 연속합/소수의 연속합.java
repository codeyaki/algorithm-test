import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 1. 소수 판별
        boolean[] isNotPrimeArr = getNotPrimeArr(n); // false가 소수
        // 2. 연속되는 부분 합 구하기 (소수만)
        int answer = getAnswer(isNotPrimeArr, n);
        System.out.println(answer);

    }

    private static int getAnswer(boolean[] isNotPrimeArr, int n) {
        int left = 2, sum = 0, result = 0;
        for (int right = 2; right < n + 1; right++) {
            if(isNotPrimeArr[right]) continue;
            // 소수가 아니라면 합
            sum += right;
            // 만약 sum이 n이 넘어가면 left 땡기기 ( n보다 같거나 작아질때까지 )
            while(sum > n) {
                if(!isNotPrimeArr[left]) sum -= left;
                left++;
            }
            if(sum == n) result++;
        }
        return result;
    }

    private static boolean[] getNotPrimeArr(int n) {
        boolean[] isNotPrimeArr = new boolean[n + 1];
        isNotPrimeArr[0] = isNotPrimeArr[1] = true;
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            // 소수는 이전 수의 배수임
            if(isNotPrimeArr[i]) continue;
            for (int j = 2 * i; j < n + 1; j += i) {
                isNotPrimeArr[j] = true;
            }
        }
        return isNotPrimeArr;
    }
}