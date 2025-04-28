package _20250429;

import java.util.*;
import java.io.*;

public class _1068_트리 {
	static List<List<Integer>> tree = new ArrayList<>();
	static int N,delete;
	static int[] son;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			tree.add(new ArrayList<>());
		}
		son = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root=0;
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp!=-1) {
				son[tmp]++;
				tree.get(tmp).add(i);
			}else {
				root=i;
			}
		}
		delete = Integer.parseInt(br.readLine());
		deleteSon(root);
		deleteTree(delete);
		int ans=0;
		for(int i=0;i<N;i++) {
			if(son[i]==0) ans++;
		}
//		System.out.println(Arrays.toString(son));
		System.out.println(ans);
	}
	static void deleteSon(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int next:tree.get(curr)) {
				if(next==delete) {
					son[curr]--;
					return;
				}
				q.add(next);
			}


		}
	}
	static void deleteTree(int node) {
		if(son[node]==0) {
			son[node]=-1;
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int next:tree.get(curr)) {
				if(son[next]==0) {
					son[next]=-1;
				} else {
					q.add(next);
				}
			}
			son[curr]=-1;

		}
	}
}
