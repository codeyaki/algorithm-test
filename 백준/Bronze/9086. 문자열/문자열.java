import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String inputLine = br.readLine();
            System.out.println(inputLine.charAt(0) + "" + inputLine.charAt(inputLine.length()-1));
        }
    }
}