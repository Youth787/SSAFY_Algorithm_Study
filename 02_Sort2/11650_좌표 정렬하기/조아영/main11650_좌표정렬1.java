import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class main11650_좌표정렬1 {


	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st; 
		int[][] arr = new int[N][2];
		
		//입력
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.parallelSort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		
//시간초과나서 로직 바꿈 
//		for(int i=0; i<N; i++) {
//			for(int j=i+1; j<N; j++) {
//				if (arr[i][0]>=arr[j][0]) {
//					int tmp0 = arr[i][0];
//					int tmp1 = arr[i][1];
//					arr[i][0] = arr[j][0];
//					arr[i][1] = arr[j][1];
//					arr[j][0] = tmp0;
//					arr[j][1] = tmp1;
//					if (arr[i][0]==arr[j][0] && arr[i][1]>arr[j][1]) {
//						int tmp = arr[i][1];
//						arr[i][1] = arr[j][1];
//						arr[j][1] = tmp;
//					}
//					
//				}
//			}
//		}
		

		for (int i=0; i<N; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
		}
		System.out.println(sb);
		
	}
	
}
