class Solution {
    int [][] arr;
    int num = 1;
    int nowX;
    int nowY;
    public int[] solution(int n) {
        int total = (n * (n+1)) / 2;
        arr = new int[n][];
        for(int i = 0; i < n; i++){
            arr[i] = new int[i + 1];
        }
        int startY = 0;
        int startX = 0;
        int endX = n - 1;
        int endY = n - 1;
        while(startX <= endX || startY <= endY){
            setNumTriangle(startY, endY, startX, endX);
            startY+=2;
            startX++;
            endX-=2;
            endY--;
        }
        int[] answer = new int[total];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i + 1; j++){
                answer[index++] = arr[i][j];
            }
        }
        return answer;
    }
    
    private void setNumTriangle(int startY, int endY, int startX, int endX){
        // 왼쪽 변 
        while(nowY < endY){
            arr[nowY++][nowX] = num++;
        }
        
        // 아랫변 채우기
        while(nowX < endX){
            arr[nowY][nowX++] = num++;
        }
        
        // 오른쪽 변 채우기
        while(nowY > startY + 1){
            arr[nowY--][nowX--] = num++;
        }
        arr[nowY++][nowX] = num++;
    }
}