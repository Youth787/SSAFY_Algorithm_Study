package _20250203;

import java.util.*;
import java.io.*;

public class _11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> lis = new ArrayList<>();
		for(int num : list) {
			int idx = Collections.binarySearch(lis,num);
			if(idx<0) idx = -(idx+1);
			if(idx==lis.size()) lis.add(num);
			else lis.set(idx,num);
		}
		
		System.out.println(lis.size());
	}

}
