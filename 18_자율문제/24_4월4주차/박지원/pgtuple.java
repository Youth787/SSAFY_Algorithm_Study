import java.util.*;

//프로그래머스 LV2 튜플 
//풀이가 상당히 다양하다.. 나는 그냥 숫자의 갯수로 순위를 정했다.
//다른사람들의 풀이에 배울게 많아보임
class Solution {
    public Object[] solution(String s) {
        int index = 2;
        String temp = "";
        HashMap<Integer, Integer> map = new HashMap<>();
        while (index < s.length() - 1) {
            char c = s.charAt(index);
            if (c == ',' || c == '}') {
                if (!temp.equals("")) {
                    int intc = Integer.parseInt(temp);
                    map.put(intc, map.getOrDefault(intc, 0) + 1);
                    temp = "";
                }
            } else if (c != '{') {
                temp += c;
            }
            index++;
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (v1, v2) -> (map.get(v2).compareTo(map.get(v1))));
        return list.toArray();
    }
}
