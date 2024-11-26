package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

class homework implements Comparable<homework>{
    int day, cup;
    public homework(int day, int cup){
        this.day = day;
        this.cup = cup;
    }

    @Override
    public int compareTo(homework o){
        if(this.day==o.day) return o.cup-this.cup;
        return this.day-o.day;
    }
}

public class bj1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<homework> homeworks = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int cup = Integer.parseInt(st.nextToken());
            homeworks.add(new homework(day,cup));
        }

        Collections.sort(homeworks);
        for(homework hw : homeworks){
            if(pq.size()<hw.day) pq.add(hw.cup);
            else if(pq.size()==hw.day){
                if(pq.peek()<hw.cup){
                    pq.poll();
                    pq.add(hw.cup);
                }
            }
        }

        int result =0;
        while(!pq.isEmpty()) result+=pq.poll();
        System.out.println(result);
    }
}

