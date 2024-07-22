//백준 카드정렬하기 자바
//그리디 + 오름차순 pq
import java.io.*;
import java.util.*;

public class Main{
    static class Card implements Comparable<Card> {
        int count;
        public Card(int count) {
            this.count = count;
        }

        @Override
        public int compareTo(Card c) {
            return this.count - c.count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Card> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {

            pq.add(new Card(Integer.parseInt(br.readLine())));
        }
        int answer = 0;
        while (!pq.isEmpty()) {
            if (n == 1) {
                System.out.println(0);
                break;
            }
            int first = pq.poll().count;
            if (pq.isEmpty()) {
                System.out.println(answer);
            } else {
                int second = pq.poll().count;
                answer += first + second;
                pq.add(new Card(first + second));
            }

        }
    }

}

// 정렬된 a, b카드묶음
// 두 묶음 합쳐 하나로 만드는데에는 a갯수 + b갯수 번의 비교를 해야함. 그러니까 오름차순하고싶은듯
// 10, 20, 40장 묶음이있다면 10 + 20 합친 뒤, 30 + 40 해야하니까 총 100번 비교해야함
// 그러나 10 + 40, 50 + 20만 하면 120번 비교함.
// 최소 몇 번의 비교가 필요한지 구하세요 뭐야이게

// cards배열을 pq(오름차순)에 넣고, 앞에서부터 빼가면서 더하고 pq가 비면 멈추기
