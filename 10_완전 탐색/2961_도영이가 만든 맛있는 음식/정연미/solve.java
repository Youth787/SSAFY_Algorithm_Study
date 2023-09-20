import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도영이가만든맛있는음식2961 {
    static int N;
    static int[][] taste;
    static boolean[] tf;
    static int mindiff = Integer.MAX_VALUE; 

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        taste = new int[N][2]; 
        tf = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        } // 입력받기 완료

        powerset(0, 1, 0);
        System.out.println(mindiff);

    }// main end

    public static void powerset(int idx, int god, int bitter) {
        // 기저부분
        if (idx == N) {
        	int false_cnt =0;
        	for(int i =0; i<N; i++) {
        		if(!tf[i]) {
        			false_cnt++;
        		}
        	}
        	if(false_cnt==N) return;
        	
            int diff = Math.abs(god - bitter);
            mindiff = Math.min(diff, mindiff);
            return;
        }

        // 재귀부분
        tf[idx] = true;
        powerset(idx + 1, god * taste[idx][0], bitter + taste[idx][1]);
        
        tf[idx] = false;
        powerset(idx + 1, god, bitter);
    }
}
