package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main2217_로프 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine()); //로프 개수 
		Integer[] arr = new Integer[n]; //내림차순으로 정렬위해 Integer로 만듦 
		
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(bf.readLine()); //각 로프가 버틸 수 있는 최대 중량 
		}
		
		//k개의 로프로 중량이 w인 물체를 들어올리면 각각의 로프에는 w/k만큼의 중량이 걸림 
		//즉 k개의 로프가 들 수 있는 중량의 최대값은 k개 로프 중 중량의 최솟값*k 	
		//ArrayList<int[]> tmp = new ArrayList<int[]>(); //정수 배열(로프 배열)을 담을 리스트를 생성 
		
		Arrays.sort(arr,Collections.reverseOrder()); //내림차순으로 정렬  
	
		int max = arr[0]*1; //우선 로프 중 가장 중량 큰 애로 초기화 해두고  
		//그것보다 작은 로프를 하나씩 꺼내서 더해보자  
		
		for (int i=0; i<n; i++) {
			int sum = arr[i]*(i+1); //중량의 최솟값 * 로프 개수 
			if (max<sum) { 
				max = sum; 
			}
		}
		System.out.println(max); //그중 최댓값 출력 
		
	}
	
}