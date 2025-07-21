import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> groupSizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int count = 0;
                int current = i;

                while (!visited[current]) {
                    visited[current] = true;
                    current = cards[current] - 1; // 1-based → 0-based
                    count++;
                }

                groupSizes.add(count);
            }
        }

        if (groupSizes.size() < 2) return 0;

        // 두 개의 가장 큰 그룹 크기 선택
        Collections.sort(groupSizes, Collections.reverseOrder());
        return groupSizes.get(0) * groupSizes.get(1);
    }
}
