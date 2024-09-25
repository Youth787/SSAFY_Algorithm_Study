package p1157_단어공부;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 * 알파벳 단어가 주어지면 가장 많이 사용된 알파벳(대소문자 구분x)이 무엇인지 알아내는 프로그램
 * 대문자 출력 여러개 존재하면 ? 출력
 * 
 * A - a 는 -32
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next().toUpperCase(); //대문자로
		char ans = '?'; //갱신할 정답
		HashMap <Character, Integer> hashmap = new HashMap<>();
		//알파벳 - 개수 매칭
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			hashmap.put(tmp, hashmap.getOrDefault(tmp, 0)+1);
		}
		
		int cnt = 0;
		for (char key: hashmap.keySet()) {
			int frequency = hashmap.get(key);
            if (frequency > cnt) {
            	cnt = frequency;
                ans = key; // 새로운 최대 빈도수 알파벳
            } else if (frequency == cnt) {
            	ans = '?';
            }
            	
		}
		System.out.println(ans);
		
	} //main
} //class
