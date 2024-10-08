//프로그래머스 양과 늑대 자바
//조건이 필요한 dfs

import java.util.*;

class Solution {
    private static int answer;
    private static ArrayList<ArrayList<Integer>> list;
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        list = new ArrayList<>();
        for (int i = 0; i <= info.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] arr: edges) {
            list.get(arr[0]).add(arr[1]);
        }
        ArrayList<Integer> next = new ArrayList<>();
        next.add(0);
        
        DFS(info, next, 0, 0, 0);
        return answer;
    }
    private static void DFS(int[] info, ArrayList<Integer> li, int node, int sheep, int wolf) {
        if (info[node] == 0) {
            sheep++;
        } else wolf++;
        if (sheep <= wolf) return;
        answer = Math.max(answer, sheep);
        ArrayList<Integer> next = new ArrayList<>(li);
        if (!list.get(node).isEmpty()) {
            next.addAll(list.get(node));
        }
        next.remove(Integer.valueOf(node));
        for (int n: next) {
            DFS(info, next, n, sheep, wolf);
        }
    }
    
}
