import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        
        int oarr[] = new int[N]; // 원본 배열
        int arr[] = new int[N]; // 정렬 할 배열
      
        HashMap<Integer, Integer> rMap = new HashMap<Integer, Integer>();	// rank를 매길 HashMap
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	 oarr[i] = arr[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr);
        
        // 순위
        int r = 0;

        // arr배열에서 rMap으로 매핑하기     
        for(int key : arr) {
        	if(!rMap.containsKey(key)) {
        		rMap.put(key, r);
        		r++;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        
        // key에 해당하는 rank 가져오기!
        for(int key : oarr) {
        	sb.append(rMap.get(key)).append(" ");
        }
        
        System.out.println(sb);
    }
}
