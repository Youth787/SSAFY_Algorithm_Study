import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        // 1. 간선들을 비용 기준으로 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        // 2. 각 정점의 부모를 자기 자신으로 초기화
        int[] parent = new int[n];
        for (int i=0;i<n;i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgesUsed = 0;

        // 3. 간선들을 하나씩 확인하며 MST를 구성
        for (int i=0;i<costs.length;i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];

            if (findParent(parent, a) != findParent(parent, b)) {
                unionParent(parent, a, b);
                totalCost += cost;
                edgesUsed++;
            }

            // 모든 섬이 연결되면 종료
            if (edgesUsed == n - 1) {
                break;
            }
        }
        answer=totalCost;
        return answer;
    }
    // 부모 찾기
    private int findParent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent, parent[x]);
        }
        return parent[x];
    }

    // 두 섬을 연결하기 (Union 연산)
    private void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);
        if (a<b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
    
}
