//p17829_222풀링
// 문제 : 2*2 정사각형으로 나누고 2번째로 큰 수만 남기고 제거, 반복하여 최종적으로 1*1 크기를 만들었을 때의 값
// N(2 ≤ N ≤ 1024)이 주어진다. N은 항상 2의 거듭제곱 꼴이다. (N=2K, 1 ≤ K ≤ 10)
// 행렬의 모든 성분은 -10,000 이상 10,000 이하의 정수

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
		board = new int [n][n]; //입력받은 n으로 행렬 사이즈 설정 
		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 완
		
		System.out.println(resize(0,0,n));
		
	}//main
	
	public static int resize(int r, int c, int size) { //현재 위치를 나타내는 r,c와 현재 행렬의 전체 크기(n이 얼마나 줄어들었는가)
		if(size == 2) { //사각형이 2*2일때		
			int [] tmp = new int[4];//전체 행렬을 2*2로 나눴을 때의 4개 원소의 값을 임시로 저장
			int idx = 0;//임시 배열의 인덱스(0~3이 될때까지)
      
			for(int i=r;i<r+2;i++) {
				for(int j=c;j<c+2;j++) {
					tmp[idx++] = board[i][j];//지금자리에서 2*2의 값을 저장
				}				
			}			
			Arrays.sort(tmp);//정렬하고
			return tmp[2];//2번째로 큰 수 return	
		} //if문: 사각형이 2*2일때
		else {//사각형이 2*2가 아닐때      
			int [] tmp = new int[4]; //전체 행렬을 2*2로 나눴을 때의 4개 원소의 값을 임시로 저장
			size = size/2; //사이즈는 반으로 줄어들 예정이다.
			
			//줄어든 사이즈로 재귀(기저: size가 2가 될때까지. 2*2)
			tmp[0] = resize(r,c,size); 
			tmp[1] = resize(r,c+size,size);
			tmp[2] = resize(r+size,c,size);
			tmp[3] = resize(r+size,c+size,size);
			
			Arrays.sort(tmp);//정렬하고
			return tmp[2];//2번째로 큰 수 return		
		}//else문:사각형이 2*2가 아닐때
	}//resize
}//class

/*
예를 들어 
-6 -8 7 -4
-5 -5 14 11
11 11 -1 -1
4 9 -2 -4 라면

resize(0,0,4)로 시작.
size가 2가 아니라서 if 문에 안걸리고 else문으로 감.
int [] tmp 만들고, size는 4/2 해서 2가 됨.

tmp[0] = resize(0,0,2)로 재귀. <2사분면>
=> size==2라서 if문에 걸림. tmp 만들고, board[0][0]&[0][1]&[1][0]&[1][1] 값 4개 저장해서 두번째로 큰 값을 리턴.
=> 재귀에서 돌아와서 tmp[0] = -5가 됨.

tmp[1] = resize(0,0+2,2)로 재귀. <1사분면>
=> size==2라서 if문에 걸림. tmp 만들고, board[0][2]&[0][3]&[1][2]&[1][3] 값 4개 저장해서 두번째로 큰 값을 리턴.
=> 재귀에서 돌아와서 tmp[1] = 11가 됨.

tmp[2] = resize(0+2,0,2)로 재귀. <3사분면>
=> size==2라서 if문에 걸림. tmp 만들고, board[2][0]&[2][1]&[3][0]&[3][1] 값 4개 저장해서 두번째로 큰 값을 리턴.
=> 재귀에서 돌아와서 tmp[2] = 11가 됨.

tmp[3] = resize(0+2,0+2,2)로 재귀. <4사분면>
=> size==2라서 if문에 걸림. tmp 만들고, board[2][2]&[2][3]&[3][2]&[3][3] 값 4개 저장해서 두번째로 큰 값을 리턴.
=> 재귀에서 돌아와서 tmp[3] = -1가 됨.

tmp에서 두번째로 큰 값을 리턴 => 답은 11


+) 
2 1 
3 4 사분면

*/
