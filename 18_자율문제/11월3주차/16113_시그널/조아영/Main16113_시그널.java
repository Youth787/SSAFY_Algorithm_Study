import java.io.*;
import java.util.*;

public class Main16113_시그널 {

	static int n, m;
	static char[][] arr; 
	static String ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = n/5;
		
		arr = new char[n][m];
		String st = br.readLine();
		
		int cnt = 0;
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<m; j++) {
				arr[i][j] = st.charAt(cnt++);
			}
			System.out.println(arr[i]);
		}
		
		findNum(0,0); //배열의 0,0부터 볼거얌 
		
		System.out.println(ans);
	
	}
	
	static char[][] number = new char[3][5];
	
	static char[][] numberOne = {{'#'},{'#'},{'#'},{'#'},{'#'}};
	
	static void findNum (int r, int c) {
		
		if (c==m) return; //만약 배열 넘어가면 리턴해야 됨 
		else if (arr[r][c]=='.') findNum(r, c+1); //해당 열의 첫칸이 공백이면 다음 열로 넘어가 
		else { //공백이 아니면(검은색이면) 
			if (arr[r][c+1]=='.') { //그 다음열 첫칸이 공백이면 숫자 1임 
				ans += '1';
			} else { //다음열 첫칸이 공백 아니면 나머지 숫자 중 뭔지 찾아야 돼 
				//구현 못함... 
			}
		}
		
	}
	
}
