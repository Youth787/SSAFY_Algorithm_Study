package p1296_팀이름정하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*
 * LOVE 개수로 ((L+O) × (L+V) × (L+E) × (O+V) × (O+E) × (V+E)) mod 100 공식에 대입
 * n개의 이름 후보가 주어졌을 때 우승 확률 높은 팀 이름 구하기(여러개면 사전순)
 * 
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		int len1 = name.length();
		//L을 모두 삭제하고, 원래 문자열 길이에서 빼서 특정 문자 개수를 구하는 방식
		int L = len1 - name.replaceAll("L", "").length();
		int O = len1 - name.replaceAll("O", "").length();
		int V = len1 - name.replaceAll("V", "").length();
		int E = len1 - name.replaceAll("E", "").length();
		
		int n = Integer.parseInt(br.readLine());
		
		int max = 0; //현재 확률 최대값
		String ans = "ZZZZZZZZZZZZZZZZZZZZ"; //이름 20글자. 제일 뒤
		
		String[] teamNames = new String[n];
		for (int i = 0; i < n; i++) {
			teamNames[i] = br.readLine();
		}
		
		Arrays.sort(teamNames); //미리 사전 순 정렬
		
		for (int i = n-1; i >= 0; i--) { //뒤부터 시작
			String teamName = teamNames[i];
			int len2 = teamName.length();
			int newL = len2 - teamName.replaceAll("L", "").length() + L;
			int newO = len2 - teamName.replaceAll("O", "").length() + O;
			int newV = len2 - teamName.replaceAll("V", "").length() + V;
			int newE = len2 - teamName.replaceAll("E", "").length() + E;
			
			int total = ((newL+newO)*(newL+newV)*(newL+newE)*(newO+newV)*(newO+newE)*(newV+newE)) % 100;
			
			if (max <= total) {
				max = total;
				ans = teamName;
			}
		}
		
		System.out.println(ans);

	} //main

} //class
