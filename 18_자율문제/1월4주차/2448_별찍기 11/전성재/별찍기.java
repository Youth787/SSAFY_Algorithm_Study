import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][(2*N)-1];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j]=' ';
			}
		}
		
		//별 채우기
		//fillStar(첫 행, 가운데 열, 가장 작은 값까지 나누기위한 것(입력받은수)) 
		fillStar(0,N-1,N);
		printStar();//출력
	}
	
	public static void fillStar(int r, int c, int n) {
		//각 트리가 가장 작은 값으로 됐을때 별찍기
		if(n==3) {
			arr[r][c]='*';//트리하나의 맨위의 별
			arr[r+1][c-1]=arr[r+1][c+1]='*';//가운데 별들
			arr[r+2][c-2]=arr[r+2][c-1]=arr[r+2][c]=arr[r+2][c+1]=arr[r+2][c+2]='*';//마지막 별들
			return;//종료
		}
		
		//가장 작은값(가장 작은트리가)이 아닐때 3*2의제곱수 이므로 2로 나눠줌.
		int size = n/2;
		fillStar(r, c, size);//모여있는 3개의 트리중 가장위쪽 트리 탐색
		fillStar(r+size, c-size, size);//3개의 트리중 아래왼쪽 트리 탐색
		fillStar(r+size, c+size, size);//3개의 트리중 아래오른쪽 트리 탐색
	}
	
	public static void printStar() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
