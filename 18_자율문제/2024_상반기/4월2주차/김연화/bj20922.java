import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main {
	public static int N, K;
	public static int[] arr;
	public static HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
	public static int answer = 0;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	arr = new int[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	simulate();
    	System.out.println(answer);
    }
    
    public static void simulate() {
    	int start = 0;
    	int end = 0;
    	while(start < N) {
    		
    		while(end < N ) {
    			
    			if(hashmap.getOrDefault(arr[end], 0) + 1 > K) { //K개의 중복값이 크다면 중단
    				break;
    			}
    			else if(hashmap.getOrDefault(arr[end], 0) + 1 <= K) {
    				hashmap.put(arr[end], hashmap.getOrDefault(arr[end], 0) + 1);	
    			}
    			
    			end+=1;
    		}
    		
    		answer = Math.max(answer,  end - start);
    		hashmap.put(arr[start], hashmap.get(arr[start]) - 1); //start가 이동하였으니 start값은 뺍니다.
    		start += 1;
    	}
	
    }
      
}
