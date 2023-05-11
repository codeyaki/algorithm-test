import java.io.*;
import java.util.StringTokenizer;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) + 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n]; // 편한 인덱싱을 위해 0추가
        for(int i = 1; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // 미리 DP로 구하기 ()
        int[][] cache = dp(n, nums);
        

        // 테스트 확인
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for(int t = 0; t < testCase; t++){
            String[] testLine = br.readLine().split(" ");
            int i = Integer.parseInt(testLine[0]);
            int j = Integer.parseInt(testLine[1]);
            answer.append(cache[i][j]).append("\n");
        }
        System.out.println(answer);
        
    }
    private static int[][] dp(int n, int[] nums){
        int[][] cache = new int[n][n]; 
        // 팰린드롬 구하기
        for(int i = 1; i < n; i++){
            // 길이 1은 무조건 팰린드롬
            cache[i][i] = 1;
            // 길이 2는 전의 수와 같다면 팰린드룸
            if(nums[i] == nums[i-1] && i >= 2) cache[i-1][i] = 1;
        }
        // 길이가 3 이상인 수열은 시작과 끝을 뺀 가운데 부분이 팰린드룸이면 1
        for(int i = 2; i < n; i++){
            for(int j = 1; j < n - i; j++){ // 시작점
                if(nums[j] == nums[j + i] && cache[j + 1][j + i -1] == 1) cache[j][j + i] = 1;
            }
        }
        return cache;

    }
}