import java.util.*;

class Solution {
    List<String> route;
    Map<String, PriorityQueue<String>> map;
    
    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        route = new ArrayList<>();
        
        // 1. 각 출발지에서 갈 수 있는 도착지를 모두 기록 (알파벳 순서대로 탐색하기 위해 PriorityQueue 사용)
        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
        }

        // 2. DFS로 경로 찾기
        dfs("ICN");
        
        // 3. 결과를 리스트에서 배열로 변환
        Collections.reverse(route); // 역순으로 경로를 저장했으므로 뒤집기
        return route.toArray(new String[route.size()]);
    }
    
    private void dfs(String start) {
        PriorityQueue<String> pq = map.get(start);
        
        // 더 이상 갈 곳이 없을 때까지 탐색
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll()); // 알파벳 순서대로 탐색하기 위해 PriorityQueue 사용
        }
        
        // 도착지를 저장 (DFS의 끝에서 역순으로 저장)
        route.add(start);
    }
}
