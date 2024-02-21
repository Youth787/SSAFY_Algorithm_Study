import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int left = 0;
    int right = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}
        
		int m = Integer.parseInt(br.readLine());
		while (left <= right) {
			int mid = (left+right)/2;
			long budget =0;
			for(int i=0; i<n; i++) {
				if(arr[i]>mid) budget += mid;
				else budget+= arr[i];
			}
			if(budget<=m) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		} //while문
		System.out.println(right);
	}//main
}//class
