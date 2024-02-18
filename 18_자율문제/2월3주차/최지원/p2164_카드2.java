package p2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 1~n장의 카드. 1번이 가장 위에, n번이 가장 아래
 * (1) 제일 위에 있는 카드(1번)를 바닥에 버리고
 * (2) 제일 위에 있는 카드(2번)를 제일 아래에 있는 카드(n번) 밑으로 옮기고
 * 
 * 가장 마지막에 남게되는 카드
 * 
 * 위, 아래로 빼고 넣는 과정이 필요하니까 => 가장 위 queue 제거 -> 그 다음 가장 위 queue 빼서, 뒤에 추가 => size가 1일때 출력
 * */

public class Main {
	public static void main(String[] args) throws IOException {
		Queue <Integer> queue = new LinkedList<>(); //queue, LinkedList
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		while (queue.size() > 1) {
			queue.remove();
			queue.add(queue.poll());
			if (queue.size() == 1) {
				break;
			}
		}
		
		System.out.println(queue.poll());
		
	} //main
} //class
