class Solution {
    public int solution(int[][] dots) {
        int[] x = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] y = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        for(int i = 0; i < dots.length; i++){
            x[0] = Math.min(x[0], dots[i][0]);
            x[1] = Math.max(x[1], dots[i][0]);
            y[0] = Math.min(y[0], dots[i][1]);
            y[1] = Math.max(y[1], dots[i][1]);
        }
        return ( x[1] - x[0] ) * ( y[1] - y[0] );
    }
}