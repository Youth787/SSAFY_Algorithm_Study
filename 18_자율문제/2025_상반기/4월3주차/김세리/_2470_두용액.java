package _20250429;

import java.util.*;
import java.io.*;

public class _2470_두용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int left=0;
		int right=n-1;
		int minDiff=Integer.MAX_VALUE;
		int num1=0;
		int num2=0;
		while(left<right) {
			int sum = arr[left] + arr[right];
			if(Math.abs(sum) < minDiff) {
				minDiff = Math.abs(sum);
				num1=arr[left];
				num2=arr[right];
			}
			
			if(sum>0) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(num1+" "+num2);
		
	}

}
