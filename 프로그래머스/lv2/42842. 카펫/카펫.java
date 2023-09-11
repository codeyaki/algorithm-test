class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        // yellow의 가로세로를 구하자.
        int x = 1,y = 1;
        for(int i = 1; i <= Math.sqrt(yellow); i++){
            if(yellow % i == 0){
                int tmpY = i;
                int tmpX = yellow / i;
                if(((tmpX + tmpY)*2 + 4) == brown){
                    x = tmpX;
                    y = tmpY;
                }
            }
        }
        return new int[]{x + 2, y + 2};
    }
}