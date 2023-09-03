package p1158_요세푸스문제;

//LinkedList사용한 풀이

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int k = sc.nextInt();//k번째 수..인덱스로 따지면 -1
		
		Queue<Integer> queue = new LinkedList<>(); 
		//add offer poll peek remove(처음값 제거)**
		for (int i=1; i<=n;i++)	queue.add(i);
		
		int cnt = 0; //시도 횟수
		sb.append("<");
		while(queue.size()>1) {//출력때문에 2개 남았을 때까지는 while 문에서. 마무리는 밖에서
			cnt++;
			//k번째 꺼내고 지우기 = poll
			//k번째 아닌 값은 다시 넣어준다
			for (int i = 0 ; i < k-1; i++) { //k번째 전까지의 수는 
				int value = queue.poll(); //뽑고
				queue.add(value); //다시 뒤에 넣는다
			}//반복
			//여기까지 왔으면 queue의 맨 앞에는 k번째의 수가 있는 상태
			sb.append(queue.poll()).append(", ");
			//poll()로 아예 빼버리고(그럼 queue 사이즈-1됨) sb에 추가
		}
		sb.append(queue.poll()).append(">");
		
		System.out.println(sb);

	}//main

}//class
