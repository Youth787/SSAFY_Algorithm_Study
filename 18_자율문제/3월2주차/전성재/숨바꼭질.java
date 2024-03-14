import java.util.*;

public class Main {
    static int n, k;
    static int[] visit = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        if (n == k) {
            System.out.println(0);
        } else {
            bfs(n);
        }
    }
        static void bfs(int n){
            Queue<Integer> q = new LinkedList<>();
            q.add(n);
            visit[n] = 1;
            while(!q.isEmpty()) {
                int x = q.poll();
                for(int i = 0; i < 3; i++) {
                    int nx;
                    if(i == 0) {
                        nx = x - 1;
                    } else if(i == 1) {
                        nx = x + 1;
                    } else {
                        nx = x * 2;
                    }
                    if(nx == k) {
                        System.out.println(visit[x]);
                        return;
                    }
                    if(nx >= 0 && nx < 100001 && visit[nx] == 0) {
                        q.add(nx);
                        visit[nx] = visit[x] + 1;
                    }
                }
            }
        }
    }
