import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isSubmit = new boolean[31];

        for (int i = 0; i < 28; i++) {
            isSubmit[Integer.parseInt(br.readLine())] = true;
        }
        for (int i = 1; i < 31; i++) {
            if (!isSubmit[i]) System.out.println(i);
        }
    }

}