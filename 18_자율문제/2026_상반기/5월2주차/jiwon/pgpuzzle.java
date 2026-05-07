import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        int left, right, level;
        left = 1;
        right = Arrays.stream(diffs).max().getAsInt();
        long time = 0;
        while (left < right) {
            level = (left + right) / 2;
            time = 0;
            for (int i = 0; i < diffs.length; i++) {
                int levDiff = diffs[i] - level;
                if (levDiff <= 0) {
                    time += times[i];
                } else {
                    int preTime = i == 0 ? 0 : times[i - 1]; 
                    int nowTime = times[i];
                    int addValue = (preTime + nowTime) * levDiff + nowTime;

                    time += addValue;
                } 
            }
            if (time > limit) {
                left = level + 1;
            } else {
                right = level;
            }
        }
        
        return right;
    }
}
