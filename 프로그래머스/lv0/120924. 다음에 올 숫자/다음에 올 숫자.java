class Solution {
    public int solution(int[] common) {
        int degree1 = common[1] - common[0];
        int degree2 = common[2] - common[1];
        if(degree1 == degree2){
            return common[common.length - 1] + degree1;
        } else{
            return common[common.length - 1] * (common[2]/common[1]);
        }
    }
}