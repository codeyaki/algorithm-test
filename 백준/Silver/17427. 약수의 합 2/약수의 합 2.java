import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Long result = 0L;
        for (int i = 1; i <= num; i++) {
            result += (num / i) * i;
        }
        System.out.println(result);
    }
}
