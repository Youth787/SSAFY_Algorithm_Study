//프로그래머스 자바 압축
//map, 구현

import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int idx = init(map);

        for (int i = 0; i < msg.length(); i++) {
            String word = "";

            while (i < msg.length() && map.containsKey(word + msg.charAt(i))) {
                word += msg.charAt(i);
                i++;
            }

            answer.add(map.get(word));

            // 남은 문자가 있는 경우
            if (i < msg.length()) {
                map.put(word + msg.charAt(i), idx);
                idx++; 
                i--;
            }
        }

        return answer;
    }

    private int init(Map<String, Integer> map) {
        int idx = 1;

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            map.put(String.valueOf(ch), idx++);
        }

        return idx;
    }
}
