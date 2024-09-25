package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class subin {
    int location;
    int cnt;
    public subin(int location, int cnt){
        this.location = location;
        this.cnt = cnt;
    }
}
public class 숨바꼭질3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int K = Integer.parseInt(input.split(" ")[1]);

        Queue<subin> q = new LinkedList<>();
        boolean[] visit = new boolean[100001];
        int result =Integer.MAX_VALUE;
        q.add(new subin(N,0));

        while(!q.isEmpty()){
            subin curr = q.poll();
            visit[curr.location] = true;
            if(curr.location==K) result = Math.min(result,curr.cnt);

            if(curr.location*2<=100000&&!visit[curr.location*2])
                q.add(new subin(curr.location*2,curr.cnt));
            if(curr.location+1<=100000&&!visit[curr.location+1])
                q.add(new subin(curr.location+1,curr.cnt+1));
            if(curr.location-1>=0&&!visit[curr.location-1])
                q.add(new subin(curr.location-1,curr.cnt+1));
        }
        System.out.println(result);
    }
}
