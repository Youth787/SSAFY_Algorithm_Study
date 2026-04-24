import java.util.*;

class Solution {
    static final int INF = 1_000_000_000;
    static int[][] pos = new int[10][2];

    public int solution(String numbers) {
        initPos();

        int[][] dp = new int[10][10];

        for (int i = 0; i < 10; i++) {
            Arrays.fill(dp[i], INF);
        }

        // 시작 위치: 왼손 4, 오른손 6
        dp[4][6] = 0;

        for (int i = 0; i < numbers.length(); i++) {
            int target = numbers.charAt(i) - '0';

            int[][] next = new int[10][10];
            for (int j = 0; j < 10; j++) {
                Arrays.fill(next[j], INF);
            }

            for (int left = 0; left < 10; left++) {
                for (int right = 0; right < 10; right++) {
                    if (dp[left][right] == INF) continue;

                    // 왼손으로 target 누르기
                    // 단, 오른손이 이미 target에 있으면 왼손은 그 자리로 이동 불가
                    if (right != target) {
                        next[target][right] = Math.min(
                                next[target][right],
                                dp[left][right] + getCost(left, target)
                        );
                    }

                    // 오른손으로 target 누르기
                    // 단, 왼손이 이미 target에 있으면 오른손은 그 자리로 이동 불가
                    if (left != target) {
                        next[left][target] = Math.min(
                                next[left][target],
                                dp[left][right] + getCost(right, target)
                        );
                    }
                }
            }

            dp = next;
        }

        int answer = INF;

        for (int left = 0; left < 10; left++) {
            for (int right = 0; right < 10; right++) {
                answer = Math.min(answer, dp[left][right]);
            }
        }

        return answer;
    }

    static void initPos() {
        pos[1] = new int[]{0, 0};
        pos[2] = new int[]{0, 1};
        pos[3] = new int[]{0, 2};
        pos[4] = new int[]{1, 0};
        pos[5] = new int[]{1, 1};
        pos[6] = new int[]{1, 2};
        pos[7] = new int[]{2, 0};
        pos[8] = new int[]{2, 1};
        pos[9] = new int[]{2, 2};
        pos[0] = new int[]{3, 1};
    }

    static int getCost(int from, int to) {
        if (from == to) return 1;

        int x1 = pos[from][0];
        int y1 = pos[from][1];
        int x2 = pos[to][0];
        int y2 = pos[to][1];

        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);

        int diagonal = Math.min(dx, dy);
        int straight = Math.max(dx, dy) - diagonal;

        //먼저 갈 수 있는 만큼 대각선으로 이동한다.
        //남은 차이는 상하좌우로 이동한다.
        return diagonal * 3 + straight * 2;
    }
}
