import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] res = new int[2];
		int s=0, e=n-1, min=Integer.MAX_VALUE;
		Arrays.sort(arr);
		while(s < e) {
			int sum = arr[s]+arr[e];
			
			if(min> Math.abs(sum)) {
				min = Math.abs(sum);
				
				res[0] = arr[s];
				res[1] = arr[e];
				
				if(sum==0) break;
			}
			
			if(sum <0) s++;
			else e--;
		}
		
		System.out.println(res[0]+" "+res[1]);

	}
}
