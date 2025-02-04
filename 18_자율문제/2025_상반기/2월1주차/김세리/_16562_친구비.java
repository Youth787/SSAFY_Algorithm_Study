package _20250210;

import java.util.*;
import java.io.*;

public class _16562_친구비 {
	static int N,M,k;
	static int[] parent, money;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		money = new int[N+1];
		parent = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			parent[i]=i;
			money[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			union(v,w);
		}
		
		Map<Integer, Integer> minCost = new HashMap<>();
		
		for(int i=1;i<=N;i++) {
			int root = find(i);
			minCost.put(root, Math.min(minCost.getOrDefault(root, Integer.MAX_VALUE), money[i]));
		}
		
		int totalCost =0;
		for(int cost:minCost.values()) {
			totalCost += cost;
		}
		
		System.out.println(totalCost<=k ? totalCost : "Oh no");
		
	}
	
	static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x]=find(parent[x]);
	}
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA != rootB) {
			if(money[rootA]<money[rootB]) {
				parent[rootB]=rootA;
			}else {
				parent[rootA]=rootB;
			}
		}
	}

}
