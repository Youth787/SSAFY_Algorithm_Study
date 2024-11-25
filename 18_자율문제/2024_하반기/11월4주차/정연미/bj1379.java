package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class lecture {
    int num; int startT; int endT;

    public lecture(int num, int startT, int endT){
        this.num=num;
        this.startT=startT;
        this.endT=endT;
    }
}

class room{
    int roomnum, end;

    public room(int roomnum, int end){
        this.roomnum = roomnum;
        this.end = end;
    }
}

public class bj1379 {
    public static void main(String[] args) throws IOException{
        PriorityQueue<lecture> pq = new PriorityQueue<>((a,b)-> {
            if(a.startT==b.startT) return a.endT-b.endT;
            return a.startT-b.startT;
        });

        PriorityQueue<room> roompq = new PriorityQueue<>((a,b)->(a.end-b.end));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N+1];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int startT = Integer.parseInt(st.nextToken());
            int endT = Integer.parseInt(st.nextToken());
            pq.add(new lecture(number,startT,endT));
        }

        while(!pq.isEmpty()){
            lecture curr = pq.poll();
            if(roompq.isEmpty()){
                result[curr.num] = 1;
                roompq.add(new room(1,curr.endT));
            }else{
                if(roompq.peek().end<=curr.startT){
                    result[curr.num] = roompq.peek().roomnum;
                    roompq.poll();
                    roompq.add(new room(result[curr.num],curr.endT));
                }else{
                    result[curr.num] = roompq.size()+1;
                    roompq.add(new room(result[curr.num],curr.endT));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(roompq.size()).append("\n");
        for(int i=1; i<=N; i++){
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
