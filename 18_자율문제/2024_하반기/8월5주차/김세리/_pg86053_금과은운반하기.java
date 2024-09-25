import java.util.*;

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = 400000000000000L;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            long totalGold = 0;
            long totalSilver = 0;
            long total = 0;

            for (int i = 0; i < g.length; i++) {
                // 해당 시간 내에 트럭이 왕복할 수 있는 최대 횟수 계산
                long tripCount = mid / (2L * t[i]);
                if (mid % (2L * t[i]) >= t[i]) {
                    tripCount++;
                }

                // 트럭이 옮길 수 있는 금과 은의 총량
                long maxGold = Math.min(g[i], tripCount*w[i]);
                long maxSilver = Math.min(s[i], tripCount*w[i]);

                // 각 도시에서 실제로 옮길 수 있는 금과 은의 합
                totalGold += maxGold;
                totalSilver += maxSilver;
                total += Math.min(g[i] + s[i], tripCount*w[i]);
            }

            // 조건을 만족하는지 확인
            if (totalGold>=a && totalSilver>=b && total>=a+b) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
