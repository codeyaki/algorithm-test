import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class Solution {
    public int solution(String before, String after) {
        String[] beforeSplit = before.split("");
        String[] afterSplit = after.split("");
        Arrays.sort(beforeSplit);
        Arrays.sort(afterSplit);
        for (int i = 0; i < beforeSplit.length; i++) {
            if (!beforeSplit[i].equals(afterSplit[i])) return 0;
        }

        return 1;
    }
}