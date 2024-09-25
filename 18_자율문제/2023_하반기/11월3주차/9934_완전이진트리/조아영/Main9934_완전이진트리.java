import java.util.*;

//어케하는거야 
public class Main9934_완전이진트리 {
	
	static int[] arr;
	static int length; 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		arr = new int[1<<k];
		System.out.println(1<<k);
		for (int i=1; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(arr));
		length = arr.length;
		inOrder(1);
		
	}
	
	static void inOrder(int i) { //중위순회 
		if (i<length) {
			inOrder(i*2);
			System.out.print(arr[i] + " ");
			inOrder(i*2+1);
		}
	}
	
}
