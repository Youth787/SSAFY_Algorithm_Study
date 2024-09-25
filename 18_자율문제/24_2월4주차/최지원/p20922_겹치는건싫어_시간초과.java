//package p20922_겹치는건싫어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
 * 홍대병 도현이가 수열에서 같은 원소가 여러 개 들어있는 수열을 싫어하니까
 * 같은 원소가 k개 이하로 들어있는 최장 연속 부분 수열의 길이를 구하여고 함
 * 길이 n인 수열에서 같은 정수를 k개 이하로 포함한 최장 연속 부분 수열의 길이 출력
 * 
 * */
public class Main {
	static int n; //원래 수열 길이
	static int k; //원소 중복 개수 제한
	static int[] arr; //원래 수열
	static int ans; //답
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		ans = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} //입력
		
		//원소 중복 확인을해야 하는데, key - value로 0번 인덱스부터 cnt하면서 확인?
		//계속 넣다가 만약에 k를 초과하는 경우가 발생하면 이제 ans와 비교해서 최대값을 ans에 갱신
		for (int i = 0; i < n; i++) { //전체 배열을 돌기 위한 for 문
			HashMap <Integer, Integer> chk = new HashMap<>();
			int cnt = 0;
			for (int j = i; j < n; j++) { //최장 연속 부분수열 확인용 for 문: k를 초과하는 경우가 생기면 break;
				int tmp = chk.getOrDefault(arr[j], 0); //arr[j]가 이미 chk에 있는지 확인하고 없으면 0을 가져온다
				chk.put(arr[j], ++tmp); //chk에 key = arr[j] 인 곳에 tmp+1한 value를 넣는다
				if (chk.get(arr[j]) > k) { //만약 k를 초과했다면 지금까지의 길이를 보고 최장 부분 수열 길이를 갱신
					ans = Math.max(ans, cnt);
					break;
				}
				cnt++; //문제가 없었다면 길이+1
			}
		}
		System.out.println(ans);	
	} //main
} //class
