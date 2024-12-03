import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[] down = new int[n/2];
		int[] up = new int[n/2];
		for(int i=0; i<n/2; i++) {
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			down[i]=a;
			up[i]=b;
		}
		Arrays.sort(up);
		Arrays.sort(down);
		int min = n;
		int cnt=0;
		for(int i=1; i<h+1; i++) {
			int conflict =binarySearch(0, n/2, i, down) + binarySearch(0, n/2, h-i+1, up);
			if(min == conflict) {
				cnt++;
				continue;
			}
			if(min > conflict) {
				min = conflict;
				cnt=1;
			}
		}
		System.out.println(min +" " +cnt);
	}
	static int binarySearch(int left, int right, int h, int[] arr) {
		while(left<right) {
			int mid = (left+right)/2;
			
			if(arr[mid] >= h) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
        return arr.length-right;
	}
}
