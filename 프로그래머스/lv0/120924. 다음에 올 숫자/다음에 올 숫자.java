class Solution {
    public int solution(int[] common) {
        int degree = common[1] - common[0];
        boolean isDif = true;
        for(int i =2; i<common.length; i++){
            int tmp = common[i] - common[i-1];
            if(degree != tmp) {
                degree = common[i]/common[i-1];
                isDif = false;
                break;
            }
            break;
        }
        return isDif ? common[common.length -1] + degree :  common[common.length -1] * degree;
    }
}