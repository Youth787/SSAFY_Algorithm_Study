import java.io.*;
import java.util.*;

//메모리초과 ㅜㅜ 
public class Main16113_시그널 {

	static int n, m;
	static char[][] arr; 
	static StringBuilder sb = new StringBuilder();
	static String[][] numbers = new String[10][1];
	
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
//			System.out.println(arr[i]);
		}
		
		numbers[0][0] = "####.##.##.####";
		numbers[1][0] = "###############"; 
		numbers[2][0] = "###..#####..###";
		numbers[3][0] = "###..####..####";
		numbers[4][0] = "#.##.####..#..#";
		numbers[5][0] = "####..###..####";
		numbers[6][0] = "####..####.####";
		numbers[7][0] = "###..#..#..#..#";
		numbers[8][0] = "####.#####.####";
		numbers[9][0] = "####.####..####";
		
		find(0,0); //배열의 0,0부터 볼거얌 
		
		System.out.println(sb.toString());
	
	}
	
	static void find (int r, int c) {
		
		if (c==m) return; //만약 배열 넘어가면 리턴해야 됨 
		else if (arr[r][c]=='.') find(r, c+1); //해당 열의 첫칸이 공백이면 다음 열로 넘어가 
		else { //공백이 아니면(검은색이면) 
			if (arr[r][c+1]=='.') { //그 다음열 첫칸이 공백이면 숫자 1임 
				sb.append("1");
			} else { //다음열 첫칸이 공백 아니면 나머지 숫자 중 뭔지 찾아야 돼 
				int findNum = 10;
				for (int k=0; k<10; k++) {
					int idx = 0;
					if (findNum<10) break; //숫자 찾았으면 더 안해 
					if (k==1) continue; //1은 해볼필요 없으니 넘어가 
					outer: for (int i=r; i<r+5; i++) {
						for (int j=c; j<c+3; j++) {
							if (arr[i][j]!=numbers[k][0].charAt(idx++)) {
								break outer; //만약 다르면 다음 숫자인지 찾아 
							}
							if (i==r+4 && j==c+2) {
								findNum = k;  //숫자 찾았으면 findNum을 바꿔 
							}
						}
					}
				}
				sb.append(findNum); //정답 문자열에 찾은 숫자 넣어줘 
			}
			find(r,c+3); //그리고 다음 숫자 ㄱㄱ 
			
		} //else end 
	} //find method end 
	
} //class end
