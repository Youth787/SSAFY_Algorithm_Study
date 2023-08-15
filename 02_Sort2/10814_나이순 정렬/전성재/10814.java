import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        String arr[][] = new String[N][2];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken(); // 나이
            arr[i][1] = st.nextToken(); // 이름
           
        }
        
        	
        Arrays.sort(arr, (String[] o1, String[] o2)-> {
        	if(o1[0] == o2[0]) {
        		return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
        		
        	}
        	else {
        		return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
        	}
        });
        
        
        
        for(int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
            
        }
        
        
    }
}
