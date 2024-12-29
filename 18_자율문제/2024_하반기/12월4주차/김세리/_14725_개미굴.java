package _20241230;

import java.util.*;
import java.io.*;

public class _14725_개미굴 {
	static class TrieNode {
		TreeMap<String, TrieNode> children = new TreeMap<>();
	}
	
	static class Trie {
		TrieNode root = new TrieNode();
		
		public void insert(String[] path) {
			TrieNode current = root;
			for(String s:path) {
				current.children.putIfAbsent(s,new TrieNode());
				current = current.children.get(s);
			}
		}
		
		public void print(TrieNode node, int depth) {
			for(String key: node.children.keySet()) {
				for(int i=0;i<depth;i++) {
					System.out.print("--");
				}
				System.out.println(key);
				print(node.children.get(key), depth+1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			String[] path = new String[K];
			for(int j=0;j<K;j++) {
				path[j] = st.nextToken();
			}
			trie.insert(path);
		}
		trie.print(trie.root,0);
		
	}

}
