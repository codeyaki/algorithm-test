import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        System.out.println(Math.abs(a - b));
    }

}