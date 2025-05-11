import java.util.*;

class Solution {
    private static final int SCALE = 65_536;

    /** 문자열을 대문자로 변환 후, 알파벳 2‑gram 다중집합을 만들어 카운트 */
    private Map<String, Integer> toMultiSet(String s) {
        Map<String, Integer> map = new HashMap<>();
        s = s.toUpperCase();

        for (int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            if (Character.isLetter(a) && Character.isLetter(b)) {
                String key = "" + a + b;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        return map;
    }

    public int solution(String str1, String str2) {
        Map<String, Integer> m1 = toMultiSet(str1);
        Map<String, Integer> m2 = toMultiSet(str2);

        // 둘 다 공집합이면 Jaccard 계수는 1
        if (m1.isEmpty() && m2.isEmpty()) {
            return SCALE;
        }

        int intersection = 0;
        int union = 0;

        // 교집합: 공통 원소의 최소 개수
        for (String key : m1.keySet()) {
            if (m2.containsKey(key)) {
                intersection += Math.min(m1.get(key), m2.get(key));
            }
        }

        // 합집합: 모든 원소의 최대 개수
        Set<String> keys = new HashSet<>();
        keys.addAll(m1.keySet());
        keys.addAll(m2.keySet());

        for (String key : keys) {
            int c1 = m1.getOrDefault(key, 0);
            int c2 = m2.getOrDefault(key, 0);
            union += Math.max(c1, c2);
        }

        return (int) ((double) intersection / union * SCALE);
    }
}
