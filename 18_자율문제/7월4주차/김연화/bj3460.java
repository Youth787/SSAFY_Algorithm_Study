import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			//순서를 저장할 변수 count 선언
			int count = 0;
			int N = Integer.parseInt(br.readLine());
			while(true) {
				//계속 나눠서 N이 1이된다면 1도 2진수이니 count를 출력하고 반복문 종료
				if(N == 1) {
					System.out.println(count);
					break;
				}
				//2진수에 1일 올대마다 count 출력
				if(N % 2 == 1) {
					System.out.print(count + " ");
				}
				count++;
				N /= 2;
			}
		}
	}

}
