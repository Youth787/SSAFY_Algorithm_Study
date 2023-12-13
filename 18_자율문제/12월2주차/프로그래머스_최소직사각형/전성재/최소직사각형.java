import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int max_x = 0;
        int max_y = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            max_x = Math.max(max_x, Math.max(sizes[i][0], sizes[i][1]));
            max_y = Math.max(max_y, Math.min(sizes[i][0], sizes[i][1]));
        }
        
        int answer = max_x * max_y;
        return answer;
    }
}
