import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//[문제] 숫자가 들어올 때마다 지금까지의 중간값을 구하는 프로그램
//외친 수의 개수가 짝수개라면 중간의 두 수 중 작은 수(ex. 4개 불렀다면 오름차순 정렬한 2번째 값)
public class Main {

	public static int n;

	public static void main(String[] args)throws IOException {

		//br, sb 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		//PriorityQueue를 2개 : min 힙과 max 힙을 따로 만들어서 중간 값을 따짐
		// 0 0 0[max의 root] / 0[min의 root] 0 이런 식으로 주어지는 수를 반띵하여 저장하겠다. 
		//그 후 max의 root노드 값과 min의 root노드 값을 비교하여(max.peek(), min.peek() 사용)
		//이 둘이 연결되어 있다고 생각했을 때 연결지점의 값이 순서가 안 맞다면 swap.
		//우리가 찾는 중간값은 결국 모든 과정을 마친 후의 max의 root노드 값(max.peek())
		
		
		//루트 노드에 최대값이 들어가도록. 
		PriorityQueue<Integer> max = new PriorityQueue<>(((o1, o2) -> o2 - o1)); //내림차순으로. Comparator.reverseOrder()라고도 쓸 수 있음
		//루트 노드에 최소값이 들어가도록. max 뒤에 이어지는 부분이라고 생각하면 됨 
		PriorityQueue<Integer> min = new PriorityQueue<>(); //오름차순으로 

		n = Integer.parseInt(br.readLine()); //외칠 수 개수

		for(int i = 0; i < n; i++) {
			//다음에 부르는 수
			int k = Integer.parseInt(br.readLine());
			
			//짝수번째 부르는 수는 max에 담는다
			if(i % 2 == 0) max.offer(k);
			// 홀수번째에 부른 수는 min에 담는다
			else min.offer(k);

			//만약 두 곳에 다 뭔가 들어가있고, max의 루트보다 min의 루트가 크다면 순서가 잘못된 경우기 때문에 둘의 위치를 바꿈
			if(!max.isEmpty() && !min.isEmpty()) {
				if(max.peek() > min.peek()) {
					int temp = max.poll(); 
					max.offer(min.poll()); //max의 루트 자리에 min의 루트값을 넣고
					min.offer(temp); //min의 루트 자리에는 max의 루트값을 넣음
				}
			}
			sb.append(max.peek()).append("\n"); //중간값 저장
		}//하나씩 부르면서 중간값 sb에 저장
		System.out.println(sb);
		
	}//main
}//class

//예제 이해
//7번의 수를 부른다.	
//1(홀수번째 불렀으니 max에 저장-지금까지의 중간값은 이 값), 5(짝수번째 불렀으니 min에 저장-지금까지의 중간값은 max에 있는 1)
//2(홀수번째 불렀으니 max에 저장. 중간값은 max의 뒤에 있는 2), 10(짝수번째 불렀으니 min에 저장, max에는 12, min에는 5 10이 있는 상태.중간값은 max의 뒤에 있는 2)
//-99(홀수번째 불렀으니max에 저장. 중간값은  max의 뒤에 있는 2), 7(짝수번째 불렀으니 min에 저장. max의 뒤에 있는 2가 중간값)
//5(홀수번째 불렀으니 max에 저장. max 맨 뒤의 5가 중간값.
