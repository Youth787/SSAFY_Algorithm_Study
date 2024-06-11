package _20240611;

import java.util.*;
import java.io.*;

public class _16165_걸그룹마스터준식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, ArrayList<String>> namemap = new HashMap<>();
		HashMap<String, String> groupmap = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			String groupname = br.readLine();
			int grouptcnt = Integer.parseInt(br.readLine());
			ArrayList<String> members = new ArrayList<>();
			for(int j=0;j<grouptcnt;j++) {
				String name = br.readLine();
				members.add(name);
				groupmap.put(name, groupname);
			}
			namemap.put(groupname, members);
		}
		
		for(int i=0;i<M;i++) {
			String tmp = br.readLine();
			int type = Integer.parseInt(br.readLine());
			if(type==0) {
				ArrayList<String> members = namemap.get(tmp);
				Collections.sort(members);
				for(String member : members) {
					System.out.println(member);
				}
			}
			else {
				System.out.println(groupmap.get(tmp));
			}
		}
	}//main

}
