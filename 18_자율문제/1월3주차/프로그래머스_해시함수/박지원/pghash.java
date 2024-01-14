import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) {
                return b[0] - a[0];
            } else {
                return a[col - 1] - b[col - 1];    
            }
        });
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int S_i = 0;
            // 각 컬럼을 i+1로 나눈 값을 더함
            for (int d : data[i])
                S_i += (d % (i + 1));
            // XOR 누적
            answer = (answer ^ S_i);
        }
        return answer;
    }
}
