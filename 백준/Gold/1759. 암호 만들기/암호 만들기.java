import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int l;
    private static int c;
    private static char[] charArray;
    private static boolean[] isUsedArray;
    private static char[] password;

    public static void main(String[] args) throws IOException {
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        isUsedArray = new boolean[c];
        charArray = new char[c];
        password = new char[l];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            charArray[i] = st.nextToken().charAt(0);
        }


        // 정렬
        Arrays.sort(charArray);

        // 풀이
        makePassword(0, 0);

        // 출력
        bw.flush();
        bw.close();
        br.close();
    }

    private static void makePassword(int index, int length) throws IOException {
        // 길이가 c만큼 되면 출력
        if (length == l) {
            if (checkPassword(password)) {
                for (char p : password) {
                    bw.append(p);
                }
                bw.append("\n");
            }
            return;
        }
        // 암호를 생성하기 위한 백트래킹
        for (int i = index; i < c; i++) {
            if (isUsedArray[i]) {
                continue;
            }
            isUsedArray[i] = true;
            password[length] = charArray[i];
            makePassword(i, length + 1);
            isUsedArray[i] = false;
        }

    }

    private static boolean checkPassword(char[] password) {
        // 암호를 구성하기 위해선 최소 한 개의 모음과 최소 두개의 자음이 필요함
        // 모음 (a, e, i, o, u)
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        int countVowels = 0;
        int countConsonants = 0;
        for (char p : password) {
            for (char vowel : vowels) {
                if (vowel == p) {
                    countVowels++;
                    break;
                }
            }
        }
        countConsonants = password.length - countVowels;
        return (countVowels >= 1 && countConsonants >= 2) ? true : false;
    }

}
