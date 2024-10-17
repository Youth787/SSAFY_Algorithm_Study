import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for(int[] wire : wires){
            // Java ArrayList에선 두 가지 remove() 매서드가 존재.
            // 1. remove(int index): 주어진 인덱스에 있는 요소를 제거
            // 2. remove(Object o): 리스트에서 주어진 객체와 동일한 첫 번쨰 요소를 제거
            
            // 우리가 의도한건 2번이므로 wire[1]을 객체로 처리해서 지워야 하므로 (Integer)을 써서 명시적 형변환을 사용한다
            graph.get(wire[0]).remove((Integer)wire[1]);
            graph.get(wire[1]).remove((Integer)wire[0]);
            
            int count = dfs(1, graph, new boolean[n+1]);
            
            int difference = Math.abs(n - 2*count);
            answer = Math.min(answer,difference);
            
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        return answer;
    }
    
    private int dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited){
        visited[node] = true;
        int count = 1;
        
        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                count += dfs(neighbor,graph,visited);
            }
        }
        return count;
    }
}
