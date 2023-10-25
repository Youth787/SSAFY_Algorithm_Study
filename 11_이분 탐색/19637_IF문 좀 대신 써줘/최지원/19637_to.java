import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문제: 캐릭터의 전투력에 맞는 칭호 출력
//입력 첫 줄: 칭호 개수 N, 캐릭터 개수 M (1 ≤ N, M ≤ 10의 5승)
//그 후 입력 n줄: 칭호의 이름(영어 대문자) 길이 1~11 문자열, 전투력 상한값을 나타내는 10의 9승 이하 정수. 
//칭호는 전투력 상한값의 비내림차순으로 주어진다. 
//그 후 입력 m줄: 캐릭터의 전투력을 나타내는 음이 아닌 정수
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());//칭호 개수
		int m = Integer.parseInt(st.nextToken());//캐릭터 개수
		String [] name = new String [n];
		long [] value = new long [n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			name[i] = st.nextToken();
			value[i] = Integer.parseInt(st.nextToken());
		}//해당 값 저장
		//다음줄들 판단해서 sb에 저장
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			long tmp = Integer.parseInt(st.nextToken());
			out: for (int j = 0; j < n; j++) {
				if (tmp <= value[j]) {
					sb.append(name[j]).append('\n');
					break out;
				}
			}
		}
		
		System.out.println(sb);
	}//main
}//class
