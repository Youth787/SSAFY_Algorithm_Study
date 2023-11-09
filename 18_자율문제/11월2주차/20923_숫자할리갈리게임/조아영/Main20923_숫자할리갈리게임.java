import java.io.*;
import java.util.*;
 
//https://ws-pace.tistory.com/45
//문제 이해가 오래 걸렸는데... deque 자료구조 특성 이해하고 있으면 + 차근차근 읽으면서 구현하면 할 수 있는 문제였던 거 같다
public class Main20923_숫자할리갈리게임 {
	
	//인간이 가장 심심함을 느낀다는 오후 1시 22분, 도도와 수연이는 숫자 할리갈리 게임을 하려고 한다. 

    //덱은 양쪽 끝에서 삽입과 삭제가 모두 가능한 자료구조 
    static Deque<Integer> doCards = new LinkedList<>(); //도도의 카드덱 
    static Deque<Integer> suCards = new LinkedList<>(); //수연이 카드덱 
    static Deque<Integer> doGround = new LinkedList<>(); //도도 그라운드 
    static Deque<Integer> suGround = new LinkedList<>(); //수연이 그라운드 
    
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
 
        int cards = Integer.parseInt(input[0]); //도도와 수연이가 가지는 카드의 개수 
        int playTime = Integer.parseInt(input[1]); //게임 진행 횟수 (=최대 turn 수) 
 
        for (int i = 0; i < cards; i++) {
            input = br.readLine().split(" ");
            doCards.push(Integer.parseInt(input[0])); //입력받아서 덱에 카드를 차곡차곡 쌓아요 
            suCards.push(Integer.parseInt(input[1]));
        }
 
        //이제 카드를 하나씩 뽑아서 그라운드에 내려놓을 거야 
        int doCard, suCard; //매 턴마다 두 사람이 뽑는 카드들 
        int turn = 0; //턴 수 
        while (true)
        {
            //도도부터 시작 (도도 턴) 
            doCard = doCards.pop(); //카드 한 장 뽑아서 
            doGround.push(doCard); //그라운드에 내려놔요 
 
            if (doCards.isEmpty()) break; //게임 중 카드덱에 있는 카드 수 0개 되면 패배 (게임 종료) 
 
            //종을 치는 사람이 그라운드의 카드 더미를 모두 가져가는데 
            //둘이 종을 치는 조건이 다름 
            //도도는 그라운드의 카드 더미(덱)의 맨 위 카드(=새로 뽑은 카드) 숫자가 5면 종을 쳐 
            if (doCard == 5) doWin(); 
            //수연이는 그라운드의 카드 더미(덱)의 맨 위 카드 둘의 숫자 합이 5면 종을 쳐 (근데 그라운드 비어 있으면 안 돼) 
            else if (suGround.size() > 0 && doCard + suGround.peek() == 5) suWin();
 
            if (++turn == playTime) break; //만약 턴 수가 최대 턴 수에 도달하면 게임 종료 
 
            // 수연이 턴 (도도와 동일) 
            suCard = suCards.pop();
            suGround.push(suCard);
 
            if (suCards.isEmpty()) break;
 
            if (suCard == 5) doWin();
            else if (doGround.size() > 0 && suCard + doGround.peek() == 5) suWin();
 
            if (++turn == playTime) break; 
        }
 
        String answer;
        if (suCards.size() == doCards.size()) answer = "dosu"; //남은 카드 수가 같으면 비긴 것 
        else answer = suCards.size() > doCards.size() ? "su" : "do"; 
        System.out.println(answer); //카드 더 많이 갖고 있는 사람이 승리
    }
 
    //종을 친 사람은 그라운드에 있는 카드 더미를 모두 가져감 
    //상대방의 그라운드에 있는 카드 더미를 뒤집어(=역순으로) 자신의 덱 아래에 합치고
    //자신의 그라운드에 있는 카드 더미도 뒤집어 자신의 덱 아래에 그대로 합침 
    static void doWin() { 
    	//상대 그라운드가 빌 때까지 카드를 뽑아서 내 카드덱에 추가할 건데 
    	//그라운드의 맨 뒤에 있는 카드부터 추가할 거라서 pollLast() 
        while (!suGround.isEmpty()) doCards.add(suGround.pollLast());
        while (!doGround.isEmpty()) doCards.add(doGround.pollLast());
    }
 
    static void suWin() {
        while (!doGround.isEmpty()) suCards.add(doGround.pollLast());
        while (!suGround.isEmpty()) suCards.add(suGround.pollLast());
    }
}
