class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = encodeQuad(arr);
        return answer;
    }
    
    private int[] encodeQuad(int[][] arr){
        int lengthY = arr.length;
        int lengthX = arr[0].length;
        
        // length가 1인 경우
        if(lengthX == 1){
            if(arr[0][0] == 1) return new int[]{0, 1};
            if(arr[0][0] == 0) return new int[]{1, 0};
        }
        
        // 1. 4등분
        int[][] quad1 = new int[lengthY / 2][lengthX / 2];
        int[][] quad2 = new int[lengthY / 2][lengthX / 2];
        int[][] quad3 = new int[lengthY / 2][lengthX / 2];
        int[][] quad4 = new int[lengthY / 2][lengthX / 2];
        int middleY = lengthY / 2;
        int middleX = lengthX / 2;
        int total = 0;
        
        for(int i = 0; i < lengthY; i++){
            for(int j = 0; j < lengthX; j++){
                total += arr[i][j];
                // 1사분면
                if( i >= middleY && j >= middleX ){
                    quad1[i - middleY][j - middleX] = arr[i][j];
                }
                // 2사분면
                if( i >= middleY && j < middleX ){
                    quad2[i - middleY][j] = arr[i][j];
                }
                // 3사분면
                if( i < middleY && j < middleX ){
                    quad3[i][j] = arr[i][j];
                }
                // 4사분면
                if( i < middleY && j >= middleX ){
                    quad4[i][j - middleY] = arr[i][j];
                }
                
            }
        }
        // 모두 같은 숫자인지 확인
        if(total == lengthX * lengthY) return new int[]{0, 1};
        else if(total == 0) return new int[]{1, 0};
        
        // 압축 불가능 인 경우 쿼드 트리진행
        int[] subResult1 = encodeQuad(quad1);
        int[] subResult2 = encodeQuad(quad2);
        int[] subResult3 = encodeQuad(quad3);
        int[] subResult4 = encodeQuad(quad4);
    
        int totalCntZero = subResult1[0] + subResult2[0] + subResult3[0] + subResult4[0];
        int totalCntOne = subResult1[1] + subResult2[1] + subResult3[1] + subResult4[1];
        return new int[]{totalCntZero, totalCntOne};
    }
}