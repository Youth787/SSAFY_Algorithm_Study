import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        // 1) 노드 최대값 구해서 배열 크기 결정
        int max = 0;
        for (int[] e : edges) max = Math.max(max, Math.max(e[0], e[1]));

        int[] indeg = new int[max + 1];
        int[] outdeg = new int[max + 1];

        // 2) 차수 계산
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            outdeg[u]++;
            indeg[v]++;
        }

        // 3) 생성 정점 G 찾기: in=0 && out>=2
        int G = 0;
        for (int i = 1; i <= max; i++) {
            if (indeg[i] == 0 && outdeg[i] >= 2) {
                G = i;
                break;
            }
        }

        // 4) 막대 / 8자 개수 세기 (G 제외)
        int sticks = 0;  // 막대
        int eights = 0;  // 8자
        for (int i = 1; i <= max; i++) {
            if (i == G) continue;
            if (outdeg[i] == 0 && indeg[i] > 0) sticks++;
            if (indeg[i] >= 2 && outdeg[i] >= 2) eights++;
        }

        // 5) 도넛 개수 = out(G) - 막대 - 8자
        int donuts = outdeg[G] - sticks - eights;

        return new int[]{G, donuts, sticks, eights};
    }
}
