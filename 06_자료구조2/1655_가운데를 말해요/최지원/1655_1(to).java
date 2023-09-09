import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//[문제] 숫자가 들어올 때마다 지금까지의 중간값을 구하는 프로그램
//외친 수의 개수가 짝수개라면 중간의 두 수 중 작은 수
public class Main {

	// https://st-lab.tistory.com/300
	//탐색에 특화된 이진트리 : 부모노드를 기준으로 왼쪽 자식은 부모보다 작고, 오른쪽 자식은 부모보다 크게.
	//중복 원소를 허용하려면, 같거나 작은 경우 느낌으로 조건 변경
	
//	public static ArrayList<Integer> nums = new ArrayList<>();
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()); //백준이가 부를 수 개수
		
		ArrayList<Integer> nums = new ArrayList<>();
		
				
		
		for(int i = 0; i < n ; i++) {
			
			int idx = i;
			
			int k = Integer.parseInt(br.readLine());
			nums.add(k); //1부터 값 넣고
			
			Collections.sort(nums); //정렬 아직 안들어간 값은 뒤쪽에 있겠고, 내가 확인해야 하는 값은 idx번 까지(1~idx번)
			
			//찾아야 하는 인덱스 번호
			if (idx%2 == 0) sb.append(nums.get(i/2)).append("\n"); //짝수면
			else sb.append(nums.get(i/2)).append("\n");
			
		}//중간값 부르는 과정

		System.out.println(sb);//출력
	}//main
	
	/*
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()); //백준이가 부를 수 개수
		
		int [] nums = new int [n]; //
		
		//절대 나오지 않는 값으로 초기화. 11111
		for (int i= 0; i<nums.length; i++) {
			nums[i] = 11111;
		}
		
		
		
		for(int i = 0; i < n ; i++) {
			
			int idx = i;
			
			int k = Integer.parseInt(br.readLine());
			nums[idx++] = k; //1부터 값 넣고
			
			Arrays.sort(nums); //정렬 아직 안들어간 값은 뒤쪽에 있겠고, 내가 확인해야 하는 값은 idx번 까지(1~idx번)
			
			//찾아야 하는 인덱스 번호
			if (idx%2 == 0) sb.append(nums[idx/2]).append("\n"); //짝수면
			else sb.append(nums[idx/2+1]).append("\n");
			
		}//중간값 부르는 과정
		System.out.println(Arrays.toString(nums));
		System.out.println(sb);//출력
	}//main
	 * 
	 * 
	 * */

}//class
