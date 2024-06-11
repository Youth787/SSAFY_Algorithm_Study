package _20240611;

import java.util.*;
import java.io.*;

public class _17219_비밀번호찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String,String> map = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String pw = st.nextToken();
			map.put(site, pw);
		}

		for(int i=0;i<M;i++) {
			String tmp = br.readLine();
			System.out.println(map.get(tmp));
		}
	}

}
