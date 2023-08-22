package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2581_소수 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		//m 이상 n 이하 수 중 소수를 골라 이들의 합과 최솟값 찾기 
		
		List<Integer> prime = new ArrayList<>(); //소수
		List<Integer> num = new ArrayList<>(); //소수 외의 숫자들 
		
		for (int i=2; i<=n; i++) {
			if (num.contains(i)) { //소수 외의 숫자에 포함되어 있는 경우 건너뜀 
				continue;
			} else { //아니라면 
				prime.add(i); //소수에 넣고 
				for (int j=i+1; j<=n; j++) { //해당 수보다 큰 수 중 i의 배수를 전부 num에 넣음 (소수의 배수는 소수아니니까 배제) 
					if (j%i==0) {
						num.add(j);
					}
				}
			}
		}
		
		int sum = 0; //합
		int min = 10001; //최솟값  
		
		for (int i : prime) { //리스트 순회하면서 
			if (i>=m) { //m보다 큰 소수를 합함 
				sum = sum+i;
		}
			if (i>=m && i<min) { //최솟값 찾음 
				min = i; 
			}
		}
		
		if (sum==0) { //조건 충족하는 소수가 없으면 
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
			
	}

}
