package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main5618_공약수 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력받음 
		
		int n = Integer.parseInt(br.readLine()); //주어지는 자연수 개수 
		String num = br.readLine(); //자연수들 문자열로 일단 받음 
		int[] arr = {};  //숫자들을 담을 배열 
		
		StringTokenizer st = new StringTokenizer(num," "); //문자열로 받은 숫자들 쪼갬 
		
		if (n==2) { //숫자 2개면 길이 2짜리 배열에 담음 
			arr = new int[2];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
		} else if (n==3) {
			arr = new int[3]; //숫자 3개면 길이 3짜리 배열에 담음 
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); //오름차순 정렬로 숫자들 중 최솟값이 arr[0]에 저장됨 
		
		int[] gys = new int[arr[0]]; //공약수 담을 배열 
		int cnt=0; //공약수 개수 
		
		//2개 또는 3개의 숫자를 1부터 arr[0]까지의 수로 나눠볼것 
		for (int i=1; i<=arr[0]; i++) { //
			switch (n) {
			case 2:
				if (arr[0]%i==0 && arr[1]%i==0) { //모든수가 i로 나누어떨어지면 
					gys[cnt]=i; cnt++;  //공약수 배열에 추가 
				}
				break;
			case 3:
				if (arr[0]%i==0 && arr[1]%i==0 && arr[2]%i==0) {
					gys[cnt]=i; cnt++;
				}
				break;
			}
		}
		
		for(int i=0; i<cnt; i++) {
			System.out.println(gys[i]);
		}
		
		
	}
	
}
