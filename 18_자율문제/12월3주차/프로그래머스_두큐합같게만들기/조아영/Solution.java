import java.util.LinkedList;
import java.util.Queue;

class Solution4 {
	public static int solution(int[] q1, int[] q2) {
		int ans = 0;
		
		long total=0;//두큐의합
		long q1Sum=0;//1번큐의합
		Queue<Integer> qq1 = new LinkedList<Integer>();
		Queue<Integer> qq2 = new LinkedList<Integer>();
		for(int i=0; i<q1.length; i++) { 
			total += q1[i]+q2[i];
			q1Sum += q1[i];
			qq1.add(q1[i]);
			qq2.add(q2[i]);
		}
		if(total%2!=0) return -1;//만약 두큐의합이 홀수면 같게 못만듦.
		
		long target = total/2;
		while(true) {
			if(ans>(q1.length+q2.length)*2) return -1;//이땐 더 순회해도 못만듦
			if(q1Sum==target) break;
			else if(q1Sum>target) {
				q1Sum-=qq1.peek();
				qq2.add(qq1.poll());
			}else {
				q1Sum += qq2.peek();
				qq1.add(qq2.poll());
			}
			ans++;
		}
		
		return ans;
	}
}
