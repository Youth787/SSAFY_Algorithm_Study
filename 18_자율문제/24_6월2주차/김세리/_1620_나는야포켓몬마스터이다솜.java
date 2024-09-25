package _20240611;

import java.util.*;
import java.io.*;

public class _1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer,String> SearchName = new HashMap<>();
		HashMap<String,Integer> SearchNum = new HashMap<>();
		for(int i=1;i<=N;i++) {
			String pm = br.readLine();
			SearchName.put(i, pm);
			SearchNum.put(pm,i);
		}
		
		for(int j=0;j<M;j++) {
			String tmp = br.readLine();
			char tmpp = tmp.charAt(0);
			if(Character.isDigit(tmpp)) {
				System.out.println(SearchName.get(Integer.parseInt(tmp)));
			}
			else {
				System.out.println(SearchNum.get(tmp));
			}
		}
		
	}//main

}
