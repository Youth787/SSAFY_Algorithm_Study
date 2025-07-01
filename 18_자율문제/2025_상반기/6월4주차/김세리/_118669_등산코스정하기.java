import java.util.*;

class Solution {
    static class Node {
        int idx, intensity;
        Node(int idx, int intensity) {
            this.idx = idx;
            this.intensity = intensity;
        }
    }
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i=0;i<=n;i++) graph.add(new ArrayList<>());
        for (int[] path : paths) {
            graph.get(path[0]).add(new Node(path[1], path[2]));
            graph.get(path[1]).add(new Node(path[0], path[2]));
        }

        boolean[] isGate = new boolean[n + 1];
        for (int gate : gates) isGate[gate] = true;

        boolean[] isSummit = new boolean[n + 1];
        for (int summit : summits) isSummit[summit] = true;

        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.intensity-b.intensity);
        for (int gate : gates) {
            intensity[gate] = 0;
            pq.offer(new Node(gate, 0));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (intensity[cur.idx] < cur.intensity) continue;
            if (isSummit[cur.idx]) continue;
            for (Node next : graph.get(cur.idx)) {
                if (isGate[next.idx]) continue;
                int maxIntensity = Math.max(cur.intensity, next.intensity);
                if (intensity[next.idx] > maxIntensity) {
                    intensity[next.idx] = maxIntensity;
                    pq.offer(new Node(next.idx, maxIntensity));
                }
            }
        }

        Arrays.sort(summits);
        int minIntensity = Integer.MAX_VALUE;
        int minSummit = 0;
        for (int summit : summits) {
            if (intensity[summit] < minIntensity) {
                minIntensity = intensity[summit];
                minSummit = summit;
            }
        }
        return new int[]{minSummit, minIntensity};
    }

}
