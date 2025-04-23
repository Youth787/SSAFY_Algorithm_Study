package _20250429;

import java.util.*;
import java.io.*;

public class _3273_두수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int left =0;
		int right=n-1;
		int count=0;
		while(left<right) {
			int sum = arr[left]+arr[right];
			if(sum==x) {
				count++;
				left++;
				right--;
			} else if(sum<x) {
				left++;
			} else {
				right--;
			}
			
		}
		System.out.println(count);
	}

}
