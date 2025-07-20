import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        // info 전처리: 16가지 key 생성
        for (String inf : info) {
            String[] spl = inf.split(" ");
            makeKey(spl, 0, "", Integer.parseInt(spl[4]));
        }
        // 점수 리스트 정렬
        for (List<Integer> l : map.values()) Collections.sort(l);

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            // 쿼리 파싱 및 key 변환
            String q = query[i].replaceAll(" and ", " ");
            String[] spl = q.split(" ");
            String key = spl[0] + spl[1] + spl[2] + spl[3];
            int score = Integer.parseInt(spl[4]);
            // 해당 key의 점수 리스트에서 조건 이상 개수(이진탐색)
            if (map.containsKey(key)) {
                List<Integer> l = map.get(key);
                answer[i] = l.size() - lowerBound(l, score);
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    // info 속성 4개, 각각 "-" 대체 조합 (재귀로 16개 key 생성)
    void makeKey(String[] arr, int idx, String key, int score) {
        if (idx == 4) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }
        // 선택/미선택(와일드카드)
        makeKey(arr, idx + 1, key + "-", score);
        makeKey(arr, idx + 1, key + arr[idx], score);
    }

    // score 이상인 첫 인덱스 (lower_bound)
    int lowerBound(List<Integer> list, int score) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) >= score) r = m;
            else l = m + 1;
        }
        return l;
    }
}
