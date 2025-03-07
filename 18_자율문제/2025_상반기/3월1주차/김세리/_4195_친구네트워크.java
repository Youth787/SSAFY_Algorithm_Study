package _20250310;

import java.util.*;
import java.io.*;

public class _4195_친구네트워크 {
	
	// 이름(키),부모 저장
	static HashMap<String,String> parent;
	// 부모,size 저장
	static HashMap<String,Integer> size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			int F = Integer.parseInt(br.readLine());
			
			parent = new HashMap<>();
			size = new HashMap<>();
			for(int i=0;i<F;i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				System.out.println(union(a,b));
			}
		}
	}
	static String find(String person) {
		if(!parent.get(person).equals(person)) {
			parent.put(person,find(parent.get(person)));
		}
		return parent.get(person);
	}
	static int union(String a, String b) {
		if(!parent.containsKey(a)) {
			parent.put(a,a);
			size.put(a,1);
		}
		if(!parent.containsKey(b)) {
			parent.put(b,b);
			size.put(b,1);
		}
		
		String rootA = find(a);
		String rootB = find(b);
		
		if(!rootA.equals(rootB)) {
			parent.put(rootB,rootA);
			size.put(rootA,size.get(rootA)+size.get(rootB));
		}
		return size.get(rootA);
	}

}
