import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] dwarfList = new int[9];

    public static void main(String[] args) throws IOException {
        // 9명의 드워프 키 입력
        for (int i = 0; i < 9; i++) {
            dwarfList[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(dwarfList);
        bruteForce();
        bw.flush();
        bw.close();
        br.close();
    }

    //브루트 포스
    private static void bruteForce() throws IOException {
        // 첫번째 난쟁이
        a: for (int i = 0; i < 3; i++) {
            // 두번째 난쟁이
            for (int j = i + 1; j < 4; j++) {
                // 세번째 난쟁이
                for (int k = j + 1; k < 5; k++) {
                    // 네번째 난쟁이
                    for (int l = k + 1; l < 6; l++) {
                        // 다섯번째 난쟁이
                        for (int h = l + 1; h < 7; h++) {
                            //여섯번째 난쟁이
                            for (int n = h + 1; n < 8; n++) {
                                //일곱번째 난쟁이
                                for (int m = n + 1; m < 9; m++) {
                                    if ((dwarfList[i] + dwarfList[j] + dwarfList[k]
                                            + dwarfList[l] + dwarfList[h] + dwarfList[n]
                                            + dwarfList[m]) == 100) {
                                        bw.append(String.valueOf(dwarfList[i])).append("\n")
                                                .append(String.valueOf(dwarfList[j])).append("\n")
                                                .append(String.valueOf(dwarfList[k])).append("\n")
                                                .append(String.valueOf(dwarfList[l])).append("\n")
                                                .append(String.valueOf(dwarfList[h])).append("\n")
                                                .append(String.valueOf(dwarfList[n])).append("\n")
                                                .append(String.valueOf(dwarfList[m]));
                                        break a;
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }
    //출력
    private static void printAnswer(List<Integer> realDwarfList) throws IOException {
        for (Integer dwarf : realDwarfList) {
            bw.append(dwarf.toString()).append("\n");
        }
    }

}
