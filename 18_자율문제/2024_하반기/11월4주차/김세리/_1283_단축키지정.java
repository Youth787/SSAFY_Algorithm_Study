package _20241120;

import java.util.*;
import java.io.*;

public class _1283_단축키지정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Set<Character> option = new HashSet<>();
		
		for(int i=0;i<N;i++) {
			String word = br.readLine();
			String[] words = word.split(" ");
			boolean chk = false; //단축키 지정 여부
			StringBuilder processedLine = new StringBuilder();
			
			for(int j=0;j<words.length;j++) {
				if(!chk) {
					char firstChar = Character.toUpperCase(words[j].charAt(0));
					if(!option.contains(firstChar)) {
						option.add(firstChar);
						chk=true;
						
						processedLine.append("[").append(words[j].charAt(0)).append("]");
						if(words[j].length()>1) {
							processedLine.append(words[j].substring(1));
						}
					} else {
						// 단축키 등록 실패->그 다음 덩어리에서 단축키 등록 시도
						processedLine.append(words[j]);
					}
				} else {
					// 이미 단축키 등록되었으므로 남은 단어 그냥 추가하면된다
					processedLine.append(words[j]);
				}
				// 단어가 뒤에 더 있으면 띄어쓰기 추가하고 다음 덩이로 넘어간다
				if(j<words.length-1) {
					processedLine.append(" ");
				}
				
			}
			
			if(!chk) {
				StringBuilder finalLine = new StringBuilder();
				for(char c : processedLine.toString().toCharArray()) {
					if(!chk && c != ' ' && !option.contains(Character.toUpperCase(c))) {
						option.add(Character.toUpperCase(c));
						chk = true;
						finalLine.append("[").append(c).append("]");
					} else {
						finalLine.append(c);
					}
				}
				processedLine = finalLine;
			}
			
			sb.append(processedLine).append("\n");
		}
		
		System.out.println(sb);
	}

}
