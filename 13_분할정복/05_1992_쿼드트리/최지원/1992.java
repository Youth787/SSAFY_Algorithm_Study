//쿼드트리 : 흑백 영상 압축표현
//문제 : 0과 1로 채워진 2차원배열에서 왼쪽위,오른쪽위,왼쪽아래,오른쪽아래로 나눠서 압축한 결과를 차례대로 괄호 안에 묶어서 표현한 결과.
//ex.  "(0(0011)(0(0111)01)1)"

import java.util.Scanner;
 
public class Main {
	
	static int [][] img;//이미지 2차원배열
	static StringBuilder sb = new StringBuilder();
 
	public static void main(String [] args) {
    
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		img = new int [n][n];	
        
		for(int i = 0; i < n; i++) {
			String tmp = sc.next();		
			for(int j = 0; j < n; j++) {
				img [i][j] = tmp.charAt(j) - '0';
			}
		}
		
		partition(0, 0, n);
		System.out.println(sb);
	}//main
	
	public static void partition(int x, int y, int size) {
		if(chk(x, y, size)) { //압축 체크하고 가능하다면
			sb.append(img[x][y]);
			return;
		}//압축
		
		int mid = size / 2;	//절반 나누기
		
		sb.append('(');	//괄호열기
		partition(x, y, mid);// 왼위
		partition(x, y + mid, mid);// 오위
		partition(x + mid, y, mid);// 왼아
		partition(x + mid, y + mid, mid);// 오아		
		sb.append(')');	//괄호닫기	
	}//QuadTree
	
	// 압축이 가능한지 해당 공간을 체크해주는 함수
	public static boolean chk(int r, int c, int size) {
		int value = img[r][c];		
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
				if(value != img[i][j]) return false;
			}//c
		}//r
		return true;//여기까지 나왔으면 true
	}//chk
}//class
