import java.util.*;

//프로그래머스 피로도 순열
//틀린코드 ㅠㅠ 왜틀려!!
//3이나와야하는데 2가나옴.
class Solution {
    static int[][] dungeon;
    static int blood, answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        blood = k;
        dungeon = dungeons;
        
        goFight(0, blood, 0);

        return answer;
    }
    static void goFight(int idx, int bleed, int cnt) {
        if (bleed <= 0 || idx > dungeon.length) {
            answer = Math.max(cnt, answer);
            return;
        }
        goFight(idx + 1, bleed, cnt);
        if (dungeon[idx][0] <= bleed) {
            goFight(idx + 1, bleed - dungeon[idx][1], cnt + 1);
        }

    }
}

//맞은코드
class Solution {  
    static boolean[] visited;  
    static int count = 0;  
  
    public int solution(int k, int[][] dungeons) {  
        visited = new boolean[dungeons.length];  
        dfs(0, k, dungeons);  
        return count;  
    }  
      
    private void dfs(int depth, int fatigue, int[][] dungeons){  
        for (int i = 0; i < dungeons.length; i++){  
            if (visited[i] || dungeons[i][0] > fatigue) {  
                continue;  
            }  
            visited[i] = true;  
            dfs(depth + 1, fatigue - dungeons[i][1], dungeons);  
            visited[i] = false;  
        }  
        count = Math.max(count, depth);  
    }  
}

