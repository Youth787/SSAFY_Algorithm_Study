import java.io.*;
import java.util.*;
public class Main {
    static int[][] floyd;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        floyd = new int[N][N];
        
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                floyd[i][j] = 101; //점의 최대 개수는 100개이므로, 점과 점은 아무리 멀어도 거리 99가 최대임.
                //즉, 거리 101로 해주는 것은 다익스트라의 Integer.MAX_VALUE와 같음.
            }
        }
        //존재하는 길이 없다. 를 101 로 표현.
        //있으면, 거리는 전부 1이니 해당 값 넣기
        
        for(int i = 0 ; i < M ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            floyd[a-1][b-1] = 1;
            floyd[b-1][a-1] = 1;
        }
        //초깃값.

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(i == j) continue;
                for(int k = 0 ; k < N ; k++) {
                    if(i == k || j == k) continue;
                    
                    if(floyd[j][k] > floyd[j][i] + floyd[i][k]) floyd[j][k] = floyd[j][i] + floyd[i][k];
                    
                }
            }
        }
        
        //플로이드 워셜로 각 점에서 각 점까지의 거리의 최솟값 다 채운 후
        //플로이드 워셜 로직 = a->c로 가는 값보다 b를 거쳐 a->b + b->c 값이 더 작다면 작은 값을 택하는 알고리즘.
        
        int min = Integer.MAX_VALUE;
        int n1 = 0;
        int n2 = 0;

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(i == j) continue;
                //두 점을 고른다. (1, 2부터 N-1, N까지)

                int now = sum(i, j);
                //고른 두 점을 기준으로 각각의 점의 거리의 최솟값을 더해나간다.
                //1, 2를 골랐으면
                //sum(1, 2) = 그 둘(1, 2)에서 3까지의 거리의 최솟값 + ... + 그 둘(1, 2)에서 N 까지의 거리의 최솟값

                if(min > now) {
                    n1 = i+1;
                    n2 = j+1;
                    min = now;
                }
                //해당 값이 최솟값이 된다면 두 점을 기록해놓는다.

            }
        }

        //기록한 두 점과 최솟값을 출력한다.
        bw.write(String.valueOf(n1) + " " + String.valueOf(n2) + " " + String.valueOf(min*2)); //min*2는 왕복이라서.
        bw.flush();
        bw.close();


    }

    static int sum(int n1, int n2) {
        int sum = 0;
        for(int i = 0 ; i < N ; i++) {
            if(i == n1 || i == n2) continue;
            sum += Math.min(floyd[n1][i], floyd[n2][i]);
        }

        return sum;
    }


}
