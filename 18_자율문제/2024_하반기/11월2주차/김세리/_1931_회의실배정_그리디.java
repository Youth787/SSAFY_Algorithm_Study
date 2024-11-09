package _20241113;

import java.util.*;
import java.io.*;

public class _1931_회의실배정_그리디 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] schedule = new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}
		// 종료시간 기준으로 정렬(종료시간 빠른게 먼저온다)
		// 종료시간 같을 경우 시작 시간 빠른게 먼저 오도록
		Arrays.sort(schedule,(a,b) -> {
			if(a[1]==b[1]) {
				return Integer.compare(a[0], b[0]);
			}
			return Integer.compare(a[1], b[1]);
		});
		
		int cnt =0;
		int lastEndTime =0;
		// 종료 시간이 먼저 오는 것부터 하나씩 넣어가면서
		// 최대한 많은 회의를 잡는다
		for(int[] meeting : schedule) {
			if(meeting[0] >= lastEndTime) {
				cnt++;
				lastEndTime = meeting[1];
			}
		}
		
		System.out.println(cnt);
	}//main

}
