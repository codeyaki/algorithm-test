import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String inputLine = br.readLine();
        for(int i = 0; i < inputLine.length(); i++){
            char c = inputLine.charAt(i);
            if(c >= 'a' && c <= 'z'){
                // 소문자인 경우 대문자로 바꾸기
                sb.append(Character.toString(c + ('A' - 'a')));
            }else{
                // 대문자인 경우 소문자로 바꾸기
                sb.append(Character.toString(c - ('A' - 'a')));
            }
        }
        System.out.println(sb);
    }
}