package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _19637_If문좀대신써줘 {
	public static class gametype{
		String name;
		int power;
		
		public gametype(String name, int power) {
			this.name = name;
			this.power = power;
		}
	}
	
	static List<gametype> list;
	static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		list = new ArrayList<gametype>();
		
  		for(int i=1; i<=N; i++){
  			input = br.readLine().split(" ");
  			list.add(new gametype(input[0],Integer.parseInt(input[1])));
		}
  		
  		for(int i =1; i<=M; i++) {
  			int score = Integer.parseInt(br.readLine());
  			sb.append(BinarySearch(score)).append("\n");
  		}
  		System.out.println(sb);
	}
	
	public static String BinarySearch(int score) {
		int st = 0;
		int ed = N-1;
		
		while(st<=ed) {
			int mid = (st+ed)/2;
			if(score > list.get(mid).power) {
				st = mid+1;
			}else {
				ed = mid-1;
			}
		}// while end 
		return list.get(ed+1).name;
	}
}
