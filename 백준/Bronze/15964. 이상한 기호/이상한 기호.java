import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        bw.append(String.valueOf((A + B) * (A - B)));
        bw.flush();
        bw.close();
        br.close();
    }
}