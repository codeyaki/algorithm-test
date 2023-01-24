import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        long sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += Long.parseLong(line[i]);
        }
        System.out.println(sum);
    }
}