import java.util.*;

class Solution3 {
    
    private static final int NOT_FOUND = 0;
    private static final int FOUND = 1;
    private static final char START = 'S';
    private static final char END = 'E';
    private static final char BUTTEN = 'L';
    private static final char EMPTY = 'O';
    private static final char BLOCK = 'X';
    
    public int solution(String[] maps) {
        char[][] map = makeMap(maps);
        int answer = bfs(map);
        return answer;
    }
    private static int bfs(char[][] map){
        int n = map.length;
        int m = map[0].length;
        boolean[][][] visited = new boolean[n][m][2];
        Queue<int[]> q = new LinkedList<>();
        boolean findStart = false;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == START){
                    q.offer(new int[]{i,j,NOT_FOUND});
                    findStart = true;
                }
            }
            if(findStart){
                break;
            }
        }
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                if(map[now[0]][now[1]] == END && now[2] == FOUND){
                    return time;
                }
                for(int i = 0 ; i < 4; i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    int found = now[2];
                    if(ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] != BLOCK &&
                       !visited[ny][nx][found]){
                        if(map[ny][nx] == BUTTEN){
                            visited[ny][nx][NOT_FOUND] = true;
                            found = FOUND;
                        }
                        q.offer(new int[]{ny,nx,found});
                        visited[ny][nx][now[2]] = true;
                    }
                }
            }
            time++;
        }
        return -1;
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static char[][] makeMap(String[] maps){
        int n = maps.length;
        int m = maps[0].length();
        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        return map;
    }
}
