package _20240611;

import java.util.*;
import java.io.*;

public class _13414_수강신청 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		// HashMap을 사용할 경우 순서가 보장되지 않으므로,
		// LinkedHashMap을 사용해야 한다
		
		LinkedHashMap<String,String> map = new LinkedHashMap<>();
		
		for(int i=0;i<L;i++) {
			String tmp = br.readLine();
			// 최신 순서 유지를 위해 기존 값 있을 경우 제거하고 다시 삽입
			// 값이 없을 경우 아무 작업도 일어나지 않는다
			map.remove(tmp);
			map.put(tmp, tmp);
		}
		int cnt = 0;
		
		// map.keySet(): 맵에 포함된 모든 키를 'Set' 형태로 반환
		// LinkedHashMap에서 이용할 경우 삽입된 순서대로 반환됨.
		for(String key : map.keySet()) {
			if(cnt==K) break;
			System.out.println(key);
			cnt++;
		}
	}//main

}
