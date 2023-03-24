import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalPicks = Arrays.stream(picks).sum() * 5;
        int mineMineralCnt = Math.min(totalPicks, minerals.length);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            // 돌 -> 철 -> 다이아 cost 기준 내림차순 정렬
            if (o1[2] == o2[2]) {
                if (o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                }
                return o2[1] - o1[1];
            }
            return o2[2] - o1[2];
        });
        // 광물을 캘수있는 만큼 5개씩 잘라서 넣기
        for (int i = 0; i < mineMineralCnt; i += 5) {
            int[] newCost = new int[3];
            for (int j = i; j < mineMineralCnt && j < i + 5; j++) {
                newCost[0] += getCostMine(0, minerals[j]);
                newCost[1] += getCostMine(1, minerals[j]);
                newCost[2] += getCostMine(2, minerals[j]);
            }
            queue.add(newCost);
        }
        // 작업하기
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] cost = queue.poll();
            // 다이아 순으로 가능하면 캐버리기
            for (int i = 0; i < 3; i++) {
                if (picks[i] > 0) {
                    answer += cost[i];
                    picks[i]--;
                    break;
                }
            }
        }
        return answer;
    }

    public int getCostMine(int axe, String mineral) {
        int cost = 0;
        switch (axe) {
            case 0: // 다이아 도끼
                cost = 1;
                break;
            case 1:
                switch (mineral) {
                    case "diamond":
                        cost = 5;
                        break;
                    default:
                        cost = 1;
                }
                break;
            case 2:
                switch (mineral) {
                    case "diamond":
                        cost = 25;
                        break;
                    case "iron":
                        cost = 5;
                        break;
                    default:
                        cost = 1;
                }
        }
        return cost;
    }

}