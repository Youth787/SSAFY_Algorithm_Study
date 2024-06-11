package _20240611;

import java.util.*;
import java.io.*;

public class _7785_회사에있는사람 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			if(s2.equals("enter")) set.add(s1);
			else set.remove(s1);
		}
		
		List<String> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());
		
		for(String name : list) {
			System.out.println(name);
		}
	}//main

}
