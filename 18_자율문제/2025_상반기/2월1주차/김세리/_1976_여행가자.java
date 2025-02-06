package _20250210;

import java.io.*;
import java.util.*;

public class _1976_여행가자 {
	static int N,M;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for(int i=0;i<=N;i++) {
			parent[i]=i;
		}
		
        StringTokenizer st;
        for(int i=1;i<=N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1;j<=N;j++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		if(tmp==1) {
        			union(i,j);
        		}
        	}
        }
        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        boolean chk=true;
        for(int i=0;i<M-1;i++) {
        	int next = Integer.parseInt(st.nextToken());
        	if(parent[first]!=parent[next]) chk=false;
        }
        
        System.out.println(Arrays.toString(parent));
        System.out.println(chk? "YES":"NO");
	}
	
	static int find(int x) {
		if(x==parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA <= rootB) {
			parent[rootB] = rootA;
		}else {
			parent[rootA] = rootB;
		}
	}

}
