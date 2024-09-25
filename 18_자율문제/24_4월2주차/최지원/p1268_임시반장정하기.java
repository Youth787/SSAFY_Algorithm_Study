package p1268_임시반장정하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 1~5학년 반 정보를 보고 임시반장 뽑기
 * 반학생 수, 학생마다 반 정보
 * 
 * */
public class Main {
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] info = new int[n][5];
		int[] sum = new int[n];
		boolean[][] checked = new boolean[n][n];
		int max = 0;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		} //입력
		for (int j = 0; j < 5; j++) { //학년별
			ArrayList<Integer>[] tmp = new ArrayList[10]; 
			for (int i = 0; i < n; i++) { //학생 돌면서(기준)
				if (tmp[info[i][j]] == null) {
					tmp[info[i][j]] = new ArrayList<>();
				}
				tmp[info[i][j]].add(i);
			}
			
			for (int i = 1; i <= 9; i++) {
				if (tmp[i] == null) {
					continue;
				}
				for (int student : tmp[i]) {
					for (int classmate : tmp[i]) {
						if (student != classmate && !checked[student][classmate]) {
							sum[student]++;
							checked[student][classmate] = true;
							if (sum[student] > max) {
								max = sum[student];
								ans = student;
							}
						}
					}
				}
			}
		}
		
		System.out.println(ans+1); //학생은 1번부터

	} //main

} //class

