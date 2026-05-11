import java.util.*;

class Solution {
    public static boolean[] visited;
    public static int n, answer;
    public static int[][] map;
    public static int[] temp;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        map = new int[dungeons.length][2];
        for (int i = 0; i < dungeons.length; i++) {
            map[i] = dungeons[i].clone();
        }
        n = k;
        temp = new int[map.length];
        visited = new boolean[dungeons.length];
        //순열
        permu(0);
        return answer;
    }
    public void permu(int idx) {
        if (idx > map.length) return;
        if (idx == map.length) {
            goDungeon();
            return;
        }

        for (int i = 0; i < map.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp[idx] = i;
            permu(idx + 1);
            visited[i] = false;
        }
    }
    public void goDungeon() {
        int k = n;
        int t = 0;
        for (int i = 0; i < temp.length; i++) {
            if (k >= map[temp[i]][0]){
                k -= map[temp[i]][1];
                t++;
            }
        }
        answer = Math.max(answer, t);
    }
}