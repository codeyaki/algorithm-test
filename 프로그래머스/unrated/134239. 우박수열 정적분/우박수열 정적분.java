import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        // 콜라츠 구하기
        int[] collartz = getCollatzArr(k);
        // 구간 별 미분 구하기
        double[] differentialArr = getSumCollatzArr(collartz);
        // 누적 합 구하기
        double[] cumulativeSum = getCumulativeSumArr(differentialArr);
        // 구간별 합 구하기
        double[] answer = getAnswer(cumulativeSum, ranges);
        return answer;
    }
    
    private double[] getAnswer(double[] cumulativeSum, int[][] ranges){
        int n = ranges.length;
        double[] answer = new double[n];
        for(int i = 0; i < n; i++){
            int start = ranges[i][0];
            int end = cumulativeSum.length + ranges[i][1] - 1;
            if(start > end) answer[i] = - 1.0;
            else answer[i] = cumulativeSum[end] - cumulativeSum[start];
        }
        return answer;
    }
    
    private double[] getCumulativeSumArr(double[] differentialArr){
        double[] result = new double[differentialArr.length];
        for(int i = 1; i < differentialArr.length; i++){
            result[i] += result[i - 1] + differentialArr[i];
            // System.out.println(result[i]);
        }
        return result;
    }
    
    private double[] getSumCollatzArr(int[] collartz){
        int n = collartz.length;
        double[] result = new double[n];
        for(int i = 1; i < n; i++){
            int min = Math.min(collartz[i], collartz[i - 1]);
            int max = Math.max(collartz[i], collartz[i - 1]);
            result[i] = min + ((max - min) / 2.0);
        }
        return result;
        
    }
    
    private int[] getCollatzArr(int num){
        List<Integer> collatzArr = new ArrayList<>();
        while(num != 1){
            collatzArr.add(num);
            if(num % 2 == 0) num /= 2;
            else num = num * 3 + 1;
        }
        collatzArr.add(1);
        return collatzArr.stream().mapToInt(Integer::intValue).toArray();
    }
}