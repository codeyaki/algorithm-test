import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;


public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        // 입력
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "add": add(Integer.parseInt(input[1])); break;
                case "remove": remove(Integer.parseInt(input[1])); break;
                case "check": check(Integer.parseInt(input[1])); break;
                case "toggle": toggle(Integer.parseInt(input[1])); break;
                case "all": all(); break;
                case "empty": empty(); break;
            }

        }

        // 출력
        bw.flush();
        bw.close();
        br.close();
    }

    private static void empty() {
        set = new HashSet<>();
    }

    private static void all() {
        for (int i = 0; i < 20; i++) {
            set.add(i + 1);
        }
    }

    private static void toggle(int x) {
        if(set.contains(x)) remove(x);
        else add(x);
    }

    private static void check(int x) throws IOException {
        if(set.contains(x)) bw.append("1").append("\n");
        else bw.append("0").append("\n");
    }

    private static void remove(int x) {
        set.remove(x);
    }

    private static void add(int x) {
        set.add(x);
    }
}
