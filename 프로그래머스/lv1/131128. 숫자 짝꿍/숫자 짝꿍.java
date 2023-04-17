import java.util.*;

class Solution {
    private int[] countX = new int[10];
    private int[] countY = new int[10];
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < X.length(); i++){
            countX[X.charAt(i) - '0']++;
        }
        for(int i = 0; i < Y.length(); i++){
            countY[Y.charAt(i) - '0']++;
        }
        for(int i = 9; i > 0; i--){
            sb.append(String.valueOf(i).repeat(Math.min(countX[i], countY[i])));
        }
        if(Math.min(countX[0], countY[0]) > 0){
            // 0일때는 2가지 경우가 있음
            // 1. 이미 숫자가 만들어져 있는 경우 = 0의 개수만큼 그대로 들어감
            if(sb.length() > 0){
                sb.append("0".repeat(Math.min(countX[0], countY[0])));
            }
            // 2. 0밖에 없는 경우 = 0이 됨
            else{
                sb.append("0");
            }
        }
        return sb.length() > 0 ? sb.toString() : "-1";
    }
}