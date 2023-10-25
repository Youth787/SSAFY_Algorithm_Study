//p17829_222풀링
// 문제 : 2*2 정사각형으로 나누고 2번째로 큰 수만 남기고 제거, 반복하여 최종적으로 1*1 크기를 만들었을 때의 값

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int [][] board;
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		board = new int [n][n];
		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(resize(0,0,n));
		
	}
	
	public static int resize(int r, int c, int size) {
		if(size == 2) { //사각형이 2*2일때
      
			int [] tmp = new int[4];//4개중 크기 비교하기 위해 
			int idx = 0;
      
			for(int i=r;i<r+2;i++) {
				for(int j=c;j<c+2;j++) {
					tmp[idx++] = board[i][j];
				}				
			}			
			Arrays.sort(tmp);//정렬하고
			return tmp[2];//2번째로 큰 수 return	
		} //if문: 사각형이 2*2일때
		else {//사각형이 2*2가 아닐때
      
			int [] tmp = new int[4]; 
			size = size/2; 
			
			tmp[0] = resize(r,c,size);
			tmp[1] = resize(r,c+size,size);
			tmp[2] = resize(r+size,c,size);
			tmp[3] = resize(r+size,c+size,size);
			
			Arrays.sort(tmp);//정렬하고
			return tmp[2];//2번째로 큰 수 return		
		}//else문:사각형이 2*2가 아닐때
	}
}//class
