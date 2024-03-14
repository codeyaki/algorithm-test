class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            String binary = "0" + Long.toBinaryString(numbers[i]);
            String[] binarySplit = binary.split("");
            // 마지막 비트가 0인 경우
            if(binarySplit[binarySplit.length - 1].equals("0")) binarySplit[binarySplit.length - 1] = "1";
            else {
                for(int index = binarySplit.length - 1;index >= 0; index--) {
                    if(binarySplit[index].equals("0")) {
                        // 0을 만나면 해당 자리를 1로, 그 이전 자리를 0으로 변경
                        binarySplit[index] = "1";
                        binarySplit[index + 1] = "0";
                        index--;
                        break;
                    }
                }
            }
            answer[i] = Long.parseLong(String.join("", binarySplit), 2);
            
        }
        return answer;
    }
}