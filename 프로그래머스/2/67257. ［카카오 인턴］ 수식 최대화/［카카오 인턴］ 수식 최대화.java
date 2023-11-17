import java.util.*;

class Solution {
    private char[][] opPermutation = new char[][]{
        {'+', '-', '*'}, {'+', '*', '-'},
        {'-', '+', '*'}, {'-', '*', '+'},
        {'*', '+', '-'}, {'*', '-', '+'}
    };
    
    public long solution(String expression) {
        List<Long> operandList = new LinkedList<>();
        List<Character> operatorList = new LinkedList<>();
        StringBuilder number = new StringBuilder();
        
        
        for(int i = 0; i < expression.length(); i++) {
            char nowChar = expression.charAt(i);
            if(nowChar >= '0' && nowChar <= '9') {
                number.append(nowChar);
            } else {
                operandList.add(Long.parseLong(number.toString()));
                operatorList.add(nowChar);
                number.setLength(0);
            }
        }
        operandList.add(Long.parseLong(number.toString()));
        
        long answer = getMaxSumAnswer(operandList, operatorList);
        return answer;
    }
    
    private long getMaxSumAnswer(List<Long> operandList, List<Character> operatorList){
        
        
        long result = 0;
        for (char[] ops : opPermutation) {
            
            List<Long> tempNumList = new ArrayList<>(operandList);
            List<Character> tempOpList = new ArrayList<>(operatorList);
            for(char op : ops) {
                for (int i = 0; i < tempOpList.size(); i++) { 
                    char nowOp = tempOpList.get(i);
                    if(nowOp == op) {
                        Long nowResult = 0L;
                        if(nowOp == '+') nowResult = tempNumList.get(i) + tempNumList.get(i + 1);
                        else if(nowOp == '-') nowResult = tempNumList.get(i) - tempNumList.get(i + 1);
                        else if(nowOp == '*') nowResult = tempNumList.get(i) * tempNumList.get(i + 1);
                        tempNumList.set(i, nowResult);
                        tempNumList.remove(i + 1);
                        tempOpList.remove(i);
                        i--;
                    }
                }
            }
            result = Math.max(result, Math.abs(tempNumList.get(0)));
        }
        
        
        return result;
    }
}