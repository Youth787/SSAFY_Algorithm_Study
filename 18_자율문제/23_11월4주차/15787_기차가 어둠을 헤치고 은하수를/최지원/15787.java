//죄송함다....
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p15787 {
	static int [] train;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());//기차 번호
		int m = Integer.parseInt(st.nextToken());//명령 수
		
		train = new int[n+1];//기차 1번부터 n번, 각 기차는 20개의 일렬로 된 좌석
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int cmd = Integer.parseInt(st.nextToken());//명령 시작:  1 2 3 4
			int tNum = Integer.parseInt(st.nextToken());//기차 번호
			
			if(cmd == 1) {
        // i번째 기차에 x번째 좌석에 사람 승차
				int sNum = Integer.parseInt(st.nextToken()); //좌석 번호
				train[tNum] |= (1 << sNum);//
			} else if (cmd == 2) {
        // i번째 기차에 x번째 좌석에 앉은 사람 하차
				int sNum = Integer.parseInt(st.nextToken());
				train[tNum] &= ~(1 << sNum);
			} else if (cmd == 3) {
        //i번째 기차에 앉아있는 승객들이 모두 한칸씩 뒤로 이동(k번째-> k+1 번째)/ 20번째 자리 앉아있던 사람은 명령 후 하차
				train[tNum] <<= 1;
				train[tNum] &= ((1 << 21) -1);			
			} else {
        // i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로 이동(k번째-> k-1 번째) / 1번째 자리 앉아있던 사람은 명령 후 하차
				train[tNum] >>= 1;
				train[tNum] &= ~1;	
			}
		}
		
		//HashSet으로 중복 제거
		HashSet <Integer> set = new HashSet<>();
		for(int i=1;i<n+1;i++) {
			set.add(train[i]);
		}
		
		// 출력
		System.out.println(set.size());
		
	}//main
}//class
