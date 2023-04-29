import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[][] place;
    private static List<Position> storeList = new ArrayList<>();
    private static List<Position> houseList = new ArrayList<>();
    private static boolean[] visitedStore;
    private static Position[] selectStore;
    private static int m, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]); // 크기 n * n
        m = Integer.parseInt(line[1]); // 최대 M개
        place = new int[n][n];
        // 치킨집 리스트
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int point = Integer.parseInt(st.nextToken());
                place[i][j] = point;
                if (point == 1) houseList.add(new Position(i, j));
                else if (point == 2) storeList.add(new Position(i, j));
            }
        }
        visitedStore = new boolean[storeList.size()];
        selectStore = new Position[m];
        // 치킨 가게 조합하기
        combinationStore(0, 0);
        // 프린트
        System.out.println(answer);
        br.close();
    }

    private static void combinationStore(int now, int count) {
        if (count == m) {
            // 그 도시의 치킨 거리 구하기
            int chikenDistance = calcChickenDistance();
            answer = Math.min(chikenDistance, answer);
            return;
        }
        for (int i = now; i < storeList.size(); i++) {
            if (visitedStore[i]) continue;
            visitedStore[i] = true;
            selectStore[count] = storeList.get(i);
            combinationStore(i, count + 1);
            visitedStore[i] = false;
        }
    }

    private static int calcChickenDistance() {
        // 모든 집들의 치킨거리의 합
        int distanceSum = 0;
        for (Position house : houseList) {
            int minDistance = Integer.MAX_VALUE;
            for (Position store : selectStore) {
                int distance = Math.abs(house.x - store.x) + Math.abs(house.y - store.y);
                minDistance = Math.min(minDistance, distance);
            }
            distanceSum += minDistance;
        }
        return distanceSum;
    }

    private static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return "(" + x + ", " + y + ")";
        }
    }

}