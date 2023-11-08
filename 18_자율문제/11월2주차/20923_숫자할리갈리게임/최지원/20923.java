//틀림
//package p20923_숫자할리갈리게임;
//도 수 각 n장. 그라운드에 위에서부터(나중에 놓은 카드부터) 숫자를 보이게 내려놓는다. 도도->수연 순
//종 : 수연 = 각 카드 더미에서 숫자 합이 5가 되는 순간(두 그라운드에 카드가 존재해야함)
//종 : 도도 = 두 카드 중 하나에 5 카드가 나오는 순간
//종 치면 상대가 깐 카드들을 다시 역순으로 만들고(뒤집고) 내 카드 밑으로, 내가 깐 카드도 역순으로 만들어서 밑에 넣는다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//덱의 카드가 0이 되거나, m번 진행 후 더 적은 카드를 가진 사람이 패. 같은 개수라면 비김
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());//카드 개수
		int m = Integer.parseInt(st.nextToken());//게임 진행 횟수
		
		Deque<Integer> deckD = new ArrayDeque<>();//도도 덱
		Deque<Integer> deckS = new ArrayDeque<>();//수연 덱
		//카드는 밑부터 입력됨(까는 것의 역순)
		for (int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			deckD.push(Integer.parseInt(st.nextToken()));
			deckS.push(Integer.parseInt(st.nextToken()));
		}//덱 입력
		
		Queue<Integer> groundD = new LinkedList<>();//도도 그라운드
		Queue<Integer> groundS = new LinkedList<>();//수연 그라운드
		
		String ans = "";//답
		
		//m번 반복문 돌기
		for (int i = 1; i <= m; i++) {
			//deque를 stack처럼 활용하여 맨 마지막에 들어간 값을 뺀다.
			int dodo = deckD.pop();
			int susu = deckS.pop();
			
			//일단 종을 치게 되든 아니든 그 숫자를 그라운드에 넣는다
			groundD.add(dodo);
			groundS.add(susu);
			
			//종칠 사람 있나 확인
			//종치는 사람 발생하면 그라운드를 비우면서 상대방꺼 먼저 덱에 queue처럼 밀어넣고, 내것도 밑에 밀어넣는다.
			if (dodo == 5 || susu == 5) {
				//도도 종
				while (!groundS.isEmpty()) deckD.add(groundS.poll());
				while (!groundD.isEmpty()) deckD.add(groundD.poll());
			} else if (dodo + susu == 5) {
				//수연 종
				while (!groundD.isEmpty()) deckS.add(groundD.poll());
				while (!groundS.isEmpty()) deckS.add(groundS.poll());
			} else {
				//누구도 종을 치지 못한다면 다음 시도로 넘어간다.
				//덱을 다 쓴 사람 발생 시 승패는 이미 결정
				if (deckD.size()==0) {
					ans = "su";
					break;
				}
				else if (deckS.size()==0) {
					ans = "do";
					break;
				}
				continue;
			}
							
			//덱을 다 쓴 사람 발생 시 승패는 이미 결정
			if (deckD.size()==0) {
				ans = "su";
				break;
			}
			else if (deckS.size()==0) {
				ans = "do";
				break;
			}
		}
	
		if (ans =="" && deckD.size() > deckS.size()) ans = "do";
		else if (ans =="" && deckD.size() < deckS.size()) ans = "su";
		else if (ans =="" && deckD.size() == deckS.size()) ans = "dosu";
		
		System.out.println(ans);
		
	}//main
}//class

/*
예제 1
카드 개수 =10개씩, 12번 게임 진행
도도 (밑: 카드 따면 놓이는 곳) 1,2,1,2,3,2,2,2,5,2 (위:제일먼저 까는 곳)
수연 (밑: 카드 따면 놓이는 곳) 2,2,2,3,1,2,5,1,1,3 (위:제일먼저 까는 곳)

그니까 결국 누군가 승패 났을 때 카드는 원래 (까지기 전) 덱에 쌓여있던 순서대로 

크게 영역 구분
도도 덱 / 도도 그라운드 / 수연 그라운드 / 수연 덱
===종 치고 나서===> 진사람 덱 / 이긴사람 덱 + 밑에 상대 그라운드 덱 + 밑에 본인 그라운드 덱 

deque 사용해서 처음 카드 입력은 stack처럼하고 
그라운드 2개는 queue로
종 치고 상대 카드 들어올때는 queue 그대로 deque을 queue처럼 사용

Deque<Integer> deckD = new ArrayDeque<>(); push
Queue<Integer> groundD = new LinkedList<>();
Deque<Integer> deckS = new ArrayDeque<>();
Queue<Integer> groundS = new LinkedList<>();
*/
