import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 시간초과 발생 
public class list {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();	
		
		for(int i =0; i<N; i++) {
			int a = Integer.parseInt(br.readLine());
			
			list.add(a);
			Collections.sort(list);
			
			if(list.size()==1) {
				sb.append(list.get(0)+"\n");
			}else if(list.size()%2==0) {
				int t = list.size()/2;
				if(list.get(t)>list.get(t-1)) sb.append(list.get(t-1)+"\n");
				else sb.append(list.get(t)+"\n");
			}else {
				sb.append(list.get(list.size()/2)+"\n");
			}
		}
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
	}// main end 
}
