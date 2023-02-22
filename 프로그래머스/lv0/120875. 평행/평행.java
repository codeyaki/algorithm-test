class Solution {
    public int solution(int[][] dots) {
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j) continue;
                    for (int l = k + 1; l < 4; l++) {
                        if (l == i || l == j) continue;
                        if (calcGradient(dots[i], dots[j]) == calcGradient(dots[k], dots[l])) return 1;
                    }
                }
            }
        }
        return 0;
    }

    float calcGradient(int[] dot1, int[] dot2) {
        return (float) (dot2[1] - dot1[1]) / (float) (dot2[0] - dot1[0]);
    }
}