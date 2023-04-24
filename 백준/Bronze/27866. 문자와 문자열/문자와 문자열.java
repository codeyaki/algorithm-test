import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = br.readLine();
        int index = Integer.parseInt(br.readLine()) - 1;
        System.out.println(getChar(inputLine, index));
    }
    public static char getChar(String string, int index){
        return string.charAt(index);
    }
}