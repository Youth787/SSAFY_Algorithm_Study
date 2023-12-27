import java.util.*;
import java.io.*;

public class Main {
    static int m, n, k;
    static boolean [][] visited;
    static int [] dr = {0, 0, -1, 1};
    static int [] dc = {-1, 1, 0, 0};
    static int size;
    static ArrayList <Integer> result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        visited = new boolean [m][n];
        result = new ArrayList<>();
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for (int r = y1; r < y2; r++) {
                for (int c = x1; c < x2; c++) {
                    visited[r][c] = true;//직사각형 안의 칸은 방문처리
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    size = 1;
                    DFS(i, j);
                    result.add(size);
                }
            }
        }//모든 칸 돌면서 방문 안한 곳 DFS
        
        Collections.sort(result);//ArrayList 오름차순 정렬
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(result.size() + "\n");
        for (int r : result) {
            sb.append(r + " ");
        }
        System.out.println(sb.toString());
    }//main
    
    public static void DFS(int r, int c) {
        visited[r][c] = true;
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc]) {
                size++;//직사각형 사이즈+1
                DFS(nr, nc);
            }
        }//사방탐색
    }//DFS
}//class
