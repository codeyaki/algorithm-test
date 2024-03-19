class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int currentTime = attacks[0][0];
        int currentHealth = health - attacks[0][1];
        for(int i = 1; i < attacks.length; i++) {
            int attackTime = attacks[i][0];
            int attackDamage = attacks[i][1];
            // 공격이 끝난후부터 다음 공격까지 붕대감기
            int term = attackTime - currentTime - 1;
            currentHealth += (term * bandage[1]) + (term / bandage[0] * bandage[2]);
            if(currentHealth > health) currentHealth = health;
            currentHealth -= attackDamage;
            currentTime = attackTime;
            if(currentHealth <= 0) return -1;
            
        }
        return currentHealth;
    }
}