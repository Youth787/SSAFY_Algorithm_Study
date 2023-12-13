import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], 1);
        }
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
        }
        
        System.out.println(map);
        for (int i = 0; i < map.size(); i++) {
            answer *= map.get(clothes[i][1]);
        }
        return answer - 1;
    }
}

//왜 틀리는지 모르겠어 같이 봐줘
