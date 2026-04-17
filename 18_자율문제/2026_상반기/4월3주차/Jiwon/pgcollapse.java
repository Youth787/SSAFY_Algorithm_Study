import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int n, m, answer;
    static Queue<int[]>[] record;
    public int solution(int[][] points, int[][] routes) {
        answer = 0;
        n = points.length;
        m = routes.length;
        record = new LinkedList[m];
        for (int i = 0; i < m; i++) record[i] = new LinkedList<>();
        
        recordRoutes(points, routes);
        findCollapse();
        
        return answer;
    }
    public static void findCollapse() {
        int escape = 0;
        int[][] map = new int[101][101];
        while (escape != m) {
            map = new int[101][101];
            escape = 0;
            for (int i = 0; i < m; i++) {
                if (record[i].isEmpty()) {
                    escape++;
                    continue;
                }
                int[] temp = record[i].poll();
                map[temp[0]][temp[1]]++;
            }
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (map[i][j] > 1) answer++;
                }
            }
        }
    }
    
    public static void recordRoutes(int[][] points, int[][] routes) {
        for (int i = 0; i < m; i++) {
            int from = routes[i][0] - 1;
            int fromR = points[from][0] - 1;
            int fromC = points[from][1] - 1;
            
            record[i].add(new int[]{fromR, fromC});
            
            for (int j = 1; j < routes[i].length; j++) {
                int to = routes[i][j] - 1;
                int toR = points[to][0] - 1;
                int toC = points[to][1] - 1;
                
                while (fromR != toR) {
                    if (fromR < toR) {
                        fromR++;
                    } else fromR--;
                    record[i].add(new int[]{fromR, fromC});
                }
                
                while(fromC != toC) {
                    if (fromC < toC) fromC++;
                    else fromC--;
                    record[i].add(new int[]{fromR, fromC});
                }
            }
        }   
    }
    
}
