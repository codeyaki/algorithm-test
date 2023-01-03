import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line;
        while (!"0".equals(line = br.readLine())) {
            String[] split = line.split("");
            boolean isPalindrome = true;
            for (int i = 0; i < split.length / 2; i++) {
                if (!split[i].equals(split[split.length - 1 - i])) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                bw.append("yes\n");
            } else {
                bw.append("no\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
