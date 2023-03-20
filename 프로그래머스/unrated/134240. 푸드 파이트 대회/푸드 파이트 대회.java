class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = food.length - 1; i > 0; i--) {
            sb.insert(0, String.valueOf(i).repeat(food[i] / 2));
            sb.append(String.valueOf(i).repeat(food[i] / 2));
        }
        return sb.toString();
    }
}