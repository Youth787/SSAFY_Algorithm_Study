import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        String arr[] = new String[N];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken(); 
        }
        
        
        	
        Arrays.sort(arr, (String o1, String o2)-> {
        	if(o1.length() == o2.length()) {
        		return o1.compareTo(o2);
        		
        	}
        	else {
        		return o1.length() - o2.length();
        	}
        });
        
        
        
        for(int i = 0; i < N-1; i++) {
        	if (arr[i].equals(arr[i+1])) {
        		continue;
        		}
            System.out.println(arr[i]);
        }
        System.out.println(arr[N-1]);
        
        
    }
}
