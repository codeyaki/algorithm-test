import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int MAX_NUMBERS = 1000000;
    private static boolean[] isNotPrimeNumberArray = new boolean[MAX_NUMBERS + 1];
    private static List<Integer> primeNumberList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        eratosthenes();
        int number;
        int primeNumber;
        a : while ((number = Integer.parseInt(br.readLine())) != 0) {
            for (int i = 0; (primeNumber = primeNumberList.get(i)) < (number / 2 + 1); i++) {
                int resultMinus = number - primeNumber;
                if (!isNotPrimeNumberArray[resultMinus]) {
                    bw.append(String.valueOf(number))
                            .append(" = ")
                            .append(String.valueOf(primeNumber))
                            .append(" + ")
                            .append(String.valueOf(resultMinus))
                            .append("\n");
                    continue a;
                }
            }
            bw.append("Goldbach's conjecture is wrong.").append("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void eratosthenes() {
        isNotPrimeNumberArray[0] = isNotPrimeNumberArray[1] = true;
        for (int i = 2; i < MAX_NUMBERS + 1; i++) {
            if (!isNotPrimeNumberArray[i]) {
                for (int j = i * 2; j < MAX_NUMBERS + 1; j += i) {
                    isNotPrimeNumberArray[j] = true;
                }
                primeNumberList.add(i);
            }
        }
    }
}
