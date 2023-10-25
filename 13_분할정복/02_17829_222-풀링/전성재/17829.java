import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] matrix;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		matrix = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(recur(0,0,N));
		
	}
	
	public static int recur(int i, int j, int size) {
		
		if(size == 2) {
			int arr[] = new int[4];
			int idx = 0;
			for(int r=i;r<i+2;r++) {
				for(int c=j;c<j+2;c++) {
					arr[idx++] = matrix[r][c];
				}
				
			}
			
			Arrays.sort(arr);
			return arr[2];
		}
		else {
			int arr[] = new int[4];
			size = size/2;
			
			arr[0] = recur(i,j,size); // 2사분면
			arr[1] = recur(i,j+size,size); // 1사분면
			arr[2] = recur(i+size,j,size); // 3사분면
			arr[3] = recur(i+size,j+size,size); // 4사분면
			
			Arrays.sort(arr);
			return arr[2];
			
		}
	}

}
