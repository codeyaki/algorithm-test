import java.io.*;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        while (n > 0) {
            if (n % 2 == 1) answer++;
            n /= 2;
        }
        bw.append(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

}