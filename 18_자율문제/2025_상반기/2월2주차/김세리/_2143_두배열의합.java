package _20250217;

import java.util.*;
import java.io.*;

public class _2143_두배열의합 {

	static HashMap<Integer,int[]> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());;
		for(int i=0;i<n;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			B[i]=Integer.parseInt(st.nextToken());
		}
		
		List<Integer> subA = new ArrayList<>();
		List<Integer> subB = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			int sum=0;
			for(int j=i;j<n;j++) {
				sum += A[j];
				subA.add(sum);
			}
		}
		
		for(int i=0;i<m;i++) {
			int sum=0;
			for(int j=i;j<m;j++) {
				sum += B[j];
				subB.add(sum);
			}
		}
		
		Collections.sort(subB);
		
		long result=0;
		for(int sumA : subA) {
			int target = T-sumA;
			result += upperBound(subB,target) - lowerBound(subB,target);
		}
		
		System.out.println(result);
	}
	// lowerBound: target 이상인 첫 번째 인덱스를 찾음
	static int lowerBound(List<Integer> list, int target) {
		int left=0, right=list.size();
		while(left<right) {
			int mid = (left+right)/2;
			if(list.get(mid)>=target) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		return left;
	}
	
	// upperBound: target 초과인 첫 번째 인덱스를 찾음
	static int upperBound(List<Integer>list, int target) {
		int left=0, right=list.size();
		while(left<right) {
			int mid = (left+right)/2;
			if(list.get(mid)>target) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		return left;
	}

}
