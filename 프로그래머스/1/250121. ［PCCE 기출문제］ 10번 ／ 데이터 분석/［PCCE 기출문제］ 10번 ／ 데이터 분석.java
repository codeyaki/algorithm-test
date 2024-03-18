import java.util.*;

class Solution {
    private List<String> indexArr = Arrays.asList(new String[]{"code", "date", "maximum", "remain"});
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> filteredData = filterData(data, ext, val_ext);
        int sortIndex = indexArr.indexOf(sort_by);
        filteredData.sort((o1, o2) -> o1[sortIndex] - o2[sortIndex]);
        return filteredData.toArray(new int[0][0]);
    }
    private List<int[]> filterData (int[][] data, String ext, int val_ext) {
        List<int[]> result = new LinkedList<>();
        int extIndex = indexArr.indexOf(ext);
        for(int[] row : data) {
            if(row[extIndex] < val_ext) result.add(row);
        }
        return result;
    }
}