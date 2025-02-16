//백준 음악프로그램 자바
//위상정렬 (https://m.blog.naver.com/ndb796/221236874984) 정리잘되어있음

import java.util.*;
import java.io.*;

public class Main {
    private static int artist, pd;
    private static int[] degree;
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        artist = Integer.parseInt(st.nextToken());
        pd = Integer.parseInt(st.nextToken());
        degree = new int[artist + 1];
        for (int i = 0; i <= artist; i++) list.add(new ArrayList<>());
        for (int i = 0; i < pd; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());
            for (int j = 1; j < num; j++) {
                int singer = Integer.parseInt(st.nextToken());
                list.get(before).add(singer);
                degree[singer]++;
                before = singer;
            }
        } //입력끝
        String ans = topologicalSort();
        System.out.println(ans);
    }
    private static String topologicalSort() {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= artist; i++) {
            if (degree[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);
            for (int next: list.get(now)) {
                degree[next]--;
                if (degree[next] == 0) q.add(next);
            }
        }

        if (result.size() != artist) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) sb.append(result.get(i)).append("\n");
        return sb.toString();
    }
}
