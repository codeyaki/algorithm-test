class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        checkSkillTree: for(String skillTree : skill_trees){
            String[] skillArr = skillTree.split("");
            boolean[] isHaveSkill = new boolean[26];
            
            for(String nowSkill : skillArr){
                int index = skill.indexOf(nowSkill);
                
                if(index > 0){
                    // 배워야하는 선행스킬이 존재하는 경우
                    for(int i = 0; i < index; i++){
                        
                        if(!isHaveSkill[skill.charAt(i) - 'A']) continue checkSkillTree;
                    }
                }
                isHaveSkill[nowSkill.charAt(0) - 'A'] = true;
            }
            answer++;
        }
        return answer;
    }
}