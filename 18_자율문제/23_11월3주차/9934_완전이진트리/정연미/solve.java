package _11월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 이진트리 {
	static List<ArrayList<Integer>> list;
	static int[] arr;
	static int L;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		arr = new int[(int)Math.pow(2, L)-1]; 
		for(int i=0; i<arr.length; i++) 
			arr[i] = Integer.parseInt(input[i]); 
		
		list = new ArrayList<>();
		for(int i=0; i<L; i++) {
			list.add(new ArrayList<>());
		}

		graph(0,arr.length-1, 0);
		
		for(int i=0; i<L; i++) {
			for(int j : list.get(i)) 
				System.out.print(j+" ");
			System.out.println();
		}
	}
	
	public static void graph(int start, int end, int level) {
		if(level == L) 
			return;
		
		int mid = (start + end)/2;
		
		list.get(level).add(arr[mid]);
		graph(start,mid-1,level+1);
		graph(mid+1,end,level+1);
	}
}
