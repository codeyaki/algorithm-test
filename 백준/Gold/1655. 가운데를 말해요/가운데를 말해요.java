import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> leftQue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> rightQue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        StringBuilder sb = new StringBuilder();
        leftQue.add(Integer.parseInt(br.readLine())); // 첫번째 요소 먼저 넣기
        sb.append(leftQue.peek()).append("\n");
        
        for(int i = 1; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            int middle = leftQue.peek(); // 현재 중간 값
            // 값 넣기
            if(num <= middle){
                // 만약 중간값보다 작거나 같다면 왼쪽 큐에 넣기
                leftQue.add(num);
            }else{
                // 반대의 경우 오른쪽 큐에 넣기
                rightQue.add(num);
            }
            // 두 큐의 크기 비교 (항상 왼쪽이 1 크거나 같아야함) 
            int dif = leftQue.size() - rightQue.size();
            if ( dif > 1 ){
                // 만약 왼쪽의 개수가 2개 이상되는 경우 오른쪽으로 하나 보내야함
                rightQue.add(leftQue.poll());
            } else if(dif < 0){
                // 만약 오른쪽이 왼쪽의 크기보다 더 크다면?
                leftQue.add(rightQue.poll());
            }
            // 중간값 출력
            sb.append(leftQue.peek());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
