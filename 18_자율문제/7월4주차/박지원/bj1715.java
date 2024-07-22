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
