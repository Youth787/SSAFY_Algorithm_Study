import java.util.*;
import java.io.*;

class Solution {
    HashMap<String,PriorityQueue<String>>map = new HashMap<>();
    List<String> route = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        int N = tickets.length;
        for(int i=0;i<N;i++){
            String start = tickets[i][0];
            String destination = tickets[i][1];
            map.putIfAbsent(start,new PriorityQueue<>());
            map.get(start).add(destination);
        }
        dfs("ICN");
        
        String[] answer = new String[N+1];
        
        Collections.reverse(route);
        
        route.toArray(answer);
        
        return answer;
    }
    private void dfs(String start){
        PriorityQueue<String> pq = map.get(start);
        while(pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        route.add(start);
    }
}
