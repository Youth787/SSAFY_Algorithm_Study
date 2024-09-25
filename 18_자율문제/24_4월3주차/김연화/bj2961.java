import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] taste;
    static boolean[] isSelected;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        taste = new int[N][2];
        isSelected = new boolean[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken()); //신맛
            taste[i][1] = Integer.parseInt(st.nextToken()); //쓴맛
        }
        subset(0);
        System.out.println(result);
    }
    //재료의 부분 집합
    static void subset(int cnt) {
        if(cnt == N) { //다 선택했다면
            result = Math.min(result, getTaste());
            return;
        }

        //부분집합에 현재 원소를 선택
        isSelected[cnt] = true;
        subset(cnt+1);

        //부분집합에 현재 원소를 비 선택
        isSelected[cnt] = false;
        subset(cnt+1);
    }

    static int getTaste() {
        int bitter = 0;
        int sour = 1;
        for(int i=0; i<N; i++) {
            if(isSelected[i]) {
                sour *= taste[i][0];
                bitter += taste[i][1];
            }
        }
        if(bitter == 0 && sour == 1) return Integer.MAX_VALUE;

        return Math.abs(bitter - sour);
    }
}
