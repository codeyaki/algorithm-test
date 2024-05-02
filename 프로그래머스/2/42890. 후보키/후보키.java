import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = bfs(relation);
        return answer;   
    }
    
    private int bfs(String[][] relation) {
        Queue<int[]> que = new LinkedList<>();
        int n = relation.length;
        int m = relation[0].length;
        for(int i = 0; i < m; i++) {
            que.add(new int[]{i});
        }
        Set<int[]> keySet = new HashSet<>();
        while(!que.isEmpty()) {
            int[] keyCombi = que.poll();
            Arrays.sort(keyCombi);
            // 최소성을 만족하는지 확인
            if(!isMinimality(keyCombi, keySet)) continue;
            // 유일성을 만족하는지 확인
            if(isUniqueness(keyCombi, relation)) {
                keySet.add(keyCombi);
                continue;
            }
            // 유일성을 만족하지 않는다면 다른 컬럼 추가
            for(int i = keyCombi[keyCombi.length - 1] + 1; i < m; i++) {
                int[] newKeyCombi = new int[keyCombi.length + 1];
                for(int j = 0; j < keyCombi.length; j++) {
                    newKeyCombi[j] = keyCombi[j];
                }
                newKeyCombi[newKeyCombi.length - 1] = i;
                que.add(newKeyCombi);
            }
        }
        return keySet.size();
    }
    private boolean isUniqueness(int[] keyCombi, String[][] relation) {
        // 행 비교
        Set<String> set = new HashSet<>();
        int countRow = relation.length;
        for(int i = 0; i < countRow; i++) {
            StringBuilder sb = new StringBuilder();
            for(int column = 0; column < keyCombi.length; column++) {
                sb.append(relation[i][keyCombi[column]]);
            }
            set.add(sb.toString());
        }
        if(countRow != set.size()) return false;
        return true;
    }
    
    private boolean isMinimality(int[] keyCombi, Set<int[]> keySet) {
        // 최소성 확인
        for(int[] ckeys : keySet) {
            Set<Integer> set = new HashSet<>();
            for(int ckey : ckeys) {
                set.add(ckey);
            }
            
            for (int key : keyCombi) {
                set.add(key);
            }
            if(set.size() == keyCombi.length) return false;
        }
        return true;
    }
    
    private String toStr(int[] keyCombi) {
        StringBuilder sb = new StringBuilder();
        for(int key : keyCombi) {
            sb.append(key);
        }
        return sb.toString();
    }
}