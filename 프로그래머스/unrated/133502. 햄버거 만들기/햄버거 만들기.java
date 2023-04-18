import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int ingre : ingredient){
            stack.push(ingre);
            while(isBurger(stack)){
                answer++;
            }
        }
        return answer;
    }
    public boolean isBurger(Stack<Integer> stack){
        if(stack.size() < 4) return false;
        // stack이므로 반대로 맞춰야함 
        int[] rightIngre = new int[]{1, 3, 2, 1};
        Stack<Integer> tmp = new Stack<>();
        boolean result = true;
        // 맨위의 4개를 꺼내서 햄버거가 될 수 있는지 확인
        for(int i = 0; i < 4; i++){
            int ingre = stack.pop();
            tmp.push(ingre);
            if(ingre != rightIngre[i]){
                result = false;
                break;
            }
        }
        // 만약 햄버거가 될 수 없다면 다시 저장해야함
        if(!result){
            while(!tmp.isEmpty()){
                stack.push(tmp.pop());
            }
        }
        return result;
    }
}