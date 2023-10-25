import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19637_IF문대신써줘 {

	static String[] title; 
	static int[] titleCeil; 
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken()); //칭호 개수
		int m = Integer.parseInt(st.nextToken()); //캐릭터 수 
		
		title = new String[n]; //칭호명
		titleCeil = new int[n]; //칭호별 전투력 상한값 
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			title[i] = st.nextToken();
			titleCeil[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<m; i++) {
			int power = Integer.parseInt(br.readLine());
			binarySearch(power);
		}
		System.out.println(sb);
	
	}
	
	//칭호별 전투력 상한값이 같은 경우에는
	//가장 먼저 입력된 칭호(titleCeil의 idx가 더 작은 칭호)를 출력 
	
	//만약에 title이 B A C / titlcCeil이 100 100 1000이면 
	//99 100 101 500 1000은 BBCCC 나와야 함 
	static void binarySearch(int power) {
		
		int st = 0; //시작점 
		int ed = titleCeil.length-1; //끝점 
		
		while (st<=ed) {
			int mid = (st+ed)/2; 
			if (power<=titleCeil[mid]) ed=mid-1;
			else st=mid+1;
		}
		sb.append(title[ed+1]).append("\n");
		return;
	}
	
}
