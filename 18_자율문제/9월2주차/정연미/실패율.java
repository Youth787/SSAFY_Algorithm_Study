import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[] arr = new double[N+2];
        double[] sum = new double[N+2];
        
        for(int i=0; i<stages.length; i++) arr[stages[i]]++;
        sum[N+1] = arr[N+1];
        for(int i=N;i>0; i--) sum[i] = arr[i]+sum[i+1];
        
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return Double.compare(a[0],b[0]);
            return Double.compare(b[1],a[1]);
        });
        
        for(int i=1; i<=N;i++){
            if(sum[i]==0) {
                pq.add(new double[]{i,0});
                continue;
            }
            pq.add(new double[]{i,arr[i]/sum[i]});
        }
        
        int[] answer = new int[pq.size()];
        for(int i=0; i<N;i++){
            double[] input = pq.poll();
            answer[i] = (int) input[0];
        }
        
        return answer;
    }
}
