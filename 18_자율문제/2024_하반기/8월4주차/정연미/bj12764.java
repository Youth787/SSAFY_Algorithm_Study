package Algo_스터디.August_4주차;

import java.io.IOException;
import java.io.*;
import java.util.*;

class node{
    int start;
    int end;
    int seatNo;
    public node(int start, int end ){
        this.start = start;
        this.end = end;
    }
}
public class bj12764 {
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 리스트에 담아주기. -> 리스트 start기준으로 오름차순 정렬
        List<node> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new node(a,b));
        }
        Collections.sort(list,(a,b)->a.start-b.start);

        PriorityQueue<node> seats = new PriorityQueue<>((a,b)->a.end-b.end);
        PriorityQueue<node> candidates = new PriorityQueue<>((a,b)->a.seatNo-b.seatNo);

        int number =0;
        int[] count = new int[n];

        for(node curr : list){
            while(!seats.isEmpty()&& seats.peek().end<curr.start){
                // 후보자로 지정해놓는다. 해당 자리를 갈아끼우기위해
                candidates.add(seats.poll());
            }
            int currseatnumber = candidates.isEmpty() ? number++ : candidates.poll().seatNo;
            count[currseatnumber]++;
            curr.seatNo = currseatnumber;
            seats.add(curr);
        }

        System.out.println(number);
        for(int a: count){
            if(a==0) break;
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
