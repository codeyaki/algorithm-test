class Solution {
    int[][] map;
    int[] position;
    int h, w;
    public int[] solution(String[] park, String[] routes) {
        h = park.length;
        w = park[0].length();
        map = new int[h][w];
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') position = new int[]{i, j};
                if(park[i].charAt(j) == 'X') map[i][j] = 1;
            }
        }

        for(int i = 0; i < routes.length; i++){
            String[] op = routes[i].split(" ");
            int distance = Integer.parseInt(op[1]);
            switch(op[0]){
                case "E":
                    move(new int[]{position[0], position[1] + distance});
                    break;
                case "S":
                    move(new int[]{position[0] + distance, position[1]});
                    break;
                case "W":
                    move(new int[]{position[0], position[1] - distance});
                    break;
                case "N":
                    move(new int[]{position[0] - distance, position[1]});
                    break;
            }
        }
        return position;
    }
    public void move(int[] end){
        // 맵 밖을 벗어나는지 확인
        if(end[0] < 0 || end[1] < 0 || end[0] >= h || end[1] >= w) return;
        // 이동 중 장애물을 만나는지 확인
        // h 이동
        if (position[0] < end[0]) {
            for (int i = position[0]; i <= end[0]; i++) {
                if (map[i][position[1]] == 1) return;
            }
        } else if (position[0] > end[0]) {
            for (int i = end[0]; i <= position[0]; i++) {
                if (map[i][position[1]] == 1) return;
            }
        }
        // w 이동
        if (position[1] < end[1]) {
            for (int i = position[1]; i <= end[1]; i++) {
                if (map[position[0]][i] == 1) return;
            }
        } else if (position[1] > end[1]){
            for (int i = end[1]; i <= position[1]; i++) {
                if(map[position[0]][i] == 1) return;
            }
        }
        // 만약 두가지 모두 해당되지 않으면 이동
        position = end;
    }
}