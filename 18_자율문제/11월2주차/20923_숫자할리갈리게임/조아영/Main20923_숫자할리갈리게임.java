import java.io.*;
import java.util.*;
 
//https://ws-pace.tistory.com/45
public class Main20923_숫자할리갈리게임 {
    static int cards, playTime;
    static Deque<Integer> doCards = new LinkedList<>();
    static Deque<Integer> suCards = new LinkedList<>();
    static Deque<Integer> doGround = new LinkedList<>();
    static Deque<Integer> suGround = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
 
        cards = Integer.parseInt(input[0]);
        playTime = Integer.parseInt(input[1]);
 
        for (int i = 0; i < cards; i++) {
            input = br.readLine().split(" ");
            doCards.push(Integer.parseInt(input[0]));
            suCards.push(Integer.parseInt(input[1]));
        }
 
        int doCard, suCard;
        int turn = 0;
        while (true)
        {
            // do Turn
            doCard = doCards.pop();
            doGround.push(doCard);
 
            if (doCards.isEmpty()) break;
 
            if (doCard == 5) doWin();
            else if (suGround.size() > 0 && doCard + suGround.peek() == 5) suWin();
 
            if (++turn == playTime) break;
 
            // su Turn
            suCard = suCards.pop();
            suGround.push(suCard);
 
            if (suCards.isEmpty()) break;
 
            if (suCard == 5) doWin();
            else if (doGround.size() > 0 && suCard + doGround.peek() == 5) suWin();
 
            if (++turn == playTime) break;
        }
 
        String s;
        if (suCards.size() == doCards.size()) s = "dosu";
        else s = suCards.size() > doCards.size() ? "su" : "do";
        System.out.println(s);
    }
 
    private static void doWin() {
 // 역순으로 자신의 카드에 추가
        while (!suGround.isEmpty()) doCards.add(suGround.pollLast());
        while (!doGround.isEmpty()) doCards.add(doGround.pollLast());
    }
 
    private static void suWin() {
 // 역순으로 자신의 카드에 추가
        while (!doGround.isEmpty()) suCards.add(doGround.pollLast());
        while (!suGround.isEmpty()) suCards.add(suGround.pollLast());
    }
}
