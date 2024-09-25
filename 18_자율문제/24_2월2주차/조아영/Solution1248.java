package m2w2;
import java.util.*;

//1248. [S/W 문제해결 응용] 3일차 - 공통조상
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15PTkqAPYCFAYD
public class Solution1248 {
    public static int[] tree;
    public static boolean[] visited;
    public static int V;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            V = sc.nextInt(); 
            int E = sc.nextInt(); 
            int a = sc.nextInt(); 
            int b = sc.nextInt(); 
            tree = new int[V + 1];
            visited = new boolean[V+1];
            for (int i = 0; i < E; i++) {
                int parent = sc.nextInt();
                int child = sc.nextInt();
                tree[child] = parent;
            }
            System.out.printf("#%d %d %d\n", tc, findNum(a,b), subTreeDepth(findNum(a,b), 1));
        }
    }
 
    public static int findNum(int a, int b) {
        while(a>0) {
            visited[a] = true;
            a = tree[a];
        }
        while(b>0) {
            if(visited[b])
                return b;
            b =tree[b];
        }
        return -1;
    }
 
    public static int subTreeDepth(int root, int cnt) {
        for(int i = 0; i<=V;i++) {
            if(root==tree[i]) {
                cnt += subTreeDepth(i,1);
            }   
        }
        return cnt;
    }
}