import java.util.*;

class Solution {
    private Stack<Timing> stack = new Stack<>(); //
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n]; 
        for (int i = 0; i < n; i++) {
            int nowPrice = prices[i];
            while(!stack.isEmpty() && stack.peek().price > nowPrice) {
                Timing current = stack.pop();
                answer[current.index] = i - current.index;
            }
            stack.push(new Timing(nowPrice, i));
        }
        while(!stack.isEmpty()) {
            Timing current = stack.pop();
            answer[current.index] = n - current.index - 1;
        }
        return answer;
    }
    
    class Timing {
        int price;
        int index;
        
        public Timing(int price, int index){
            this.price = price;
            this.index = index;
        }
        
        public String toString(){
            return "{" +price + "," + index + "}";
        }
    }
}