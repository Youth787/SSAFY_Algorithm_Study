import java.util.*;
import java.io.*;
//진짜 너무 어렵다.. 3차원문제...후..

class Node {
    int x; // r
    int y; // c
    int z; // height
    public Node(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class Main {
    static int n, m, h;
  //6방향 갈 arr만들어주기
    static int rowArr[] = {-1, 0, 1, 0, 0, 0};
    static int colArr[] = {0, 1, 0, -1, 0, 0};
    static int hArr[] = {0, 0, 0, 0, 1, -1};
  
    static int arr[][][];
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h + 1][n + 1][m + 1]; // 3차원 배열 만들어주고 입력받는다.
        for (int k = 1; k <= h; k++) { // 높이 
            for (int i = 1; i <= n; i++) { // 가로
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= m; j++) { // 세로
                    arr[k][i][j] = Integer.parseInt(st.nextToken());
                  //입력받으면서 만약 토마토가 있다면 q에 넣어주기
                    if (arr[k][i][j] == 1) q.add(new Node(i, j, k));
                }
            }

        }
        System.out.println(bfs());
        

    }
    static int bfs() {
        while (!q.isEmpty()) {
            Node node = q.poll();
            int height = node.z;
            int r = node.x;
            int c = node.y;

            for (int i = 0; i < 6; i++) { // 6방향 이동해주면서 갈수있는 곳이라면 큐에 추가
                int moveH = height + hArr[i];
                int moveR = r + rowArr[i];
                int moveC = c + colArr[i];
                if (checkNode(moveH, moveR, moveC)) {
                    q.add(new Node(moveR, moveC, moveH));
                  //큐에 추가해주고, 배열에 +1해주면 답을 쉽게 구할 수 있다!!(1일차 0, 2일차 1, 3일차 2 이렇게 들어갈거니까)
                    arr[moveH][moveR][moveC] = arr[height][r][c] + 1;
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for (int k = 1; k <= h; k++) { // 높이
            for (int i = 1; i <= n; i++) { // 가로
                for (int j = 1; j <= m; j++) { // 세로
                  //토마토가 안익었다면 -1 반환.
                    if (arr[k][i][j] == 0) return -1;
                  //아니라면 최대값 비교해서 result 갱신
                    result = Math.max(result, arr[k][i][j]);
                }
            }
        }
        return result - 1;

    }
    static boolean checkNode(int height, int r, int c) { // 갈수 있는 곳인지 확인하는 함수
        if (height < 1 || height > h || r < 1 || r > n || c < 1 || c > m) return false;
        if (arr[height][r][c] == 0) return true; // 토마토 안익었으면 고고
        else return false; // 익었거나 토마토가 없다면 가지마
    }
}

//https://dragon-h.tistory.com/17
