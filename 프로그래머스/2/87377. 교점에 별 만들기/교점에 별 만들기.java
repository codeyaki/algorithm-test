import java.util.*;
class Solution {
    long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE
        , maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
    
    public String[] solution(int[][] line) {
        // 모든 교점 찾기
        var crossPoints = getCrossPoints(line);
        // 그리기
        String[] answer = draw(crossPoints);
        return answer;
    }
    
    
    private String[] draw(Set<Point> starPoints) {
        int lengthX = (int) (maxX - minX + 1);
        int lengthY = (int) (maxY - minY + 1);
        char[][] paper = new char[lengthY][lengthX];
        for(int i = 0; i < lengthY; i++) {
            Arrays.fill(paper[i], '.');
        }
        
        // * 넣기
        for (Point p : starPoints) {
            paper[(int) (maxY - p.y)][(int) (p.x - minX)] = '*';
        }
        
        // string[]으로 전환
        String[] answer = new String[lengthY];
        for(int i = 0; i < lengthY; i++) {
            answer[i] = new String(paper[i]);
        }
        
        return answer;
    }
    
    private Set<Point> getCrossPoints(int[][] line) {
        int n = line.length;
        Set<Point> crossPoints = new HashSet<>(); 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // x = (BF-ED)/(AD - BC), y = (EC - AF)/(AD - BC)
                if(i == j) continue;
                long A = (long) line[i][0], B = (long) line[i][1], E = (long) line[i][2]
                    , C = (long) line[j][0], D = (long) line[j][1], F = (long) line[j][2];
                if ((A*D - B*C) == 0) {
                    continue; // 기울기가 같으면 교점이 없다.
                }
                if ((B*F - E*D) % (A*D - B*C) != 0
                     || (E*C - A*F) % (A*D - B*C) != 0) continue; // 교점이 정수가 아닌경우 
                
                long x = (B*F - E*D) / (A*D - B*C);
                long y = (E*C - A*F) / (A*D - B*C);
                
                if(minX > x) minX = x;
                if(minY > y) minY = y;
                if(maxX < x) maxX = x;
                if(maxY < y) maxY = y;
                
                crossPoints.add(new Point(x, y));
            }
        }
        return crossPoints;
    }
    
}

class Point {
    long x;
    long y;
    
    public Point (long x, long y) {
        this.x = x;
        this.y = y;
    }
    
    public int hashCode() {
        return Objects.hash(x, y);
    }
    
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Objects.equals(point.x, this.x) && Objects.equals(point.y, this.y);
    }
    
    public String toString() {
        return "{" + x + ", " + y +"}";
    }
}