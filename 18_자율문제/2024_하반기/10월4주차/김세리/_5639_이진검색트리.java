package _20241025;

import java.util.*;
import java.io.*;

public class _5639_이진검색트리 {
	static class Node{
		int value;
		Node left, right;
		
		Node(int value){
			this.value = value;
		}
		
		void insert(int val) {
			
			if(val < this.value) {
				
				if(this.left == null) this.left = new Node(val);
				else this.left.insert(val);
				
			} else {
				
				if(this.right == null) this.right = new Node(val);
				else this.right.insert(val);
				
			}
		}
	}
	
	// 후위 순회
	static void postOrder(Node node) {
		if (node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.value);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		Node root = null;
		
		// 입력으로 이진 트리 생성
		while(true) {
			input = br.readLine();
			if(input==null || input.isEmpty()) break;
			
			int value = Integer.parseInt(input);
			
			if(root==null) root = new Node(value);
			else root.insert(value);
			
		}
		postOrder(root);
	}

}
