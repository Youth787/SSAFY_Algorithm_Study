//백준 친구 자바
//그래프, BFS

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'Y') {
                    list.get(i).add(j);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int temp = BFS(i);
            max = Math.max(max, temp);
        }
        System.out.println(max);
    }
    private static int BFS(int start) {
        int depth = 0;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(start);
        visited[start] = true;
        while (depth < 2) {
            int len = q.size();
            for (int j = 0; j < len; j++) {
                int now = q.poll();
                for (int i = 0; i < n; i++) {
                    if (list.get(now).contains(i) && !visited[i]) {
                        q.add(i);
                        visited[i] = true;
                        count++;
                    }
                }
            }

            depth++;
        }
        return count;
    }
}
