//프로그래머스 메뉴 리뉴얼 자바
//dfs..아직도사실잘이해안감

import java.util.*;

class Solution {
	
    private static Map<String, Integer> map;
    private static int max = 0;
    
    public void dfs(String order, String key, int index, int end, int depth) {
    	// 코스의 길이와 동일할 때까지 탐색했을 경우
        if (depth == end) {
            map.put(key, map.getOrDefault(key, 0) + 1);
            max = Math.max(max, map.get(key));
        }
        
        for (int i = index + 1; i < order.length(); i++) {
            dfs(order, key + order.charAt(i), i, end, depth + 1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> ans = new ArrayList<>();
        
        // course 배열만큼 반복
        for(int c : course) {
        	// HashMap, max 값 초기화
            map = new HashMap<>();
            max = 0;
            
            // 주문서만큼 반복
            for(String order: orders) {
            	// 각 주문마다 알파벳 순서대로 정렬
                char[] strs = order.toCharArray();
                Arrays.sort(strs);
                order = new String(strs);
                // dfs 탐색 시작
                dfs(order, "", -1, c, 0);
            }
            
            // map에 저장된 key 개수만큼 반복
            for(String key : map.keySet()) {
            	// key값으로 value를 불러옴
                int value = map.get(key);
                // value가 2 이상이면서 max랑 동일하다면
                if(value > 1 && max == value) {
                	// 배열에 키값을 저장
                    ans.add(key);
                }
            }
        }
        
        // 정렬을 진행
        Collections.sort(ans);
        // String[] 배열로 변환
        String[] answer = ans.toArray(new String[ans.size()]);
        
        return answer;
    }
}
