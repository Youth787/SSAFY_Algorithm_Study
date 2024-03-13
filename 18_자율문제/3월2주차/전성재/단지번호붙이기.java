import java.util.*;

public class Main {
    static int[][] arr;
    static int n;
    // 단지 번호를 붙일 변수
    static int cnt = 0;
    // 결과값을 넣을 ArrayList
    static ArrayList<Integer> result = new ArrayList<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    dfs(i, j);
                    result.add(cnt);
                    cnt = 0;
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

        static boolean dfs(int x, int y){
            if(x < 0 || x >= n || y < 0 || y >= n)
                return false;
            if(arr[x][y] == 1){
                arr[x][y] = 0;
                cnt++;
                for(int i = 0; i < 4; i++){
                    dfs(x + dx[i], y + dy[i]);
                }
                return true;
            }
            return false;
        }
    }
