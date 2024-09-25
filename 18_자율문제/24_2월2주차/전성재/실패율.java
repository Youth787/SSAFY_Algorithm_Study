import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 스테이지별 도달했으나 클리어하지 못한 사람 수
        int[] currentStages = new int[N + 1];
        // 스테이지별 도달한 사람 수
        int[] clearStages = new int[N + 1];

        for (int i = 0; i < stages.length; i++) {
            for (int j = 0; j < stages[i]; j++) {
                clearStages[j] += 1;
            }
            currentStages[stages[i] - 1] += 1;
        }

        Map<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (currentStages[i] == 0 || clearStages[i] == 0) {
                map.put(i + 1, 0.0);
            } else {
                map.put(i + 1, (double) currentStages[i] / (double) clearStages[i]);
            }
        }

        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey() - o2.getKey();
            }
            return Double.compare(o2.getValue(), o1.getValue());
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).getKey();
        }

        return answer;
    }
}
