package m2w2;
import java.io.*;
import java.util.*;

//1231. [S/W 문제해결 기본] 9일차 - 중위순회
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV140YnqAIECFAYD
public class Solution1231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = 1;
		for (int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			String[] tree = new String[n+1]; //정점을 담을 트리 배열 
			for (int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int node = Integer.parseInt(st.nextToken());
				tree[node] = st.nextToken(); //완전 이진트리이므로 그냥 쭉 담으면 됨
			}
			System.out.print("#"+t+" ");
			inorder(tree,1);
			System.out.println();
		}
	}
	public static void inorder(String[] tree, int node) {
		if (node<tree.length) { //트리 범위 안에서만 순회 
			inorder(tree,node*2);
			visit(tree, node);
			inorder(tree,node*2+1);
		}
	}
	public static void visit(String[] tree, int node) {
		System.out.print(tree[node]);
	}
}
