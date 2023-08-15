import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class main10814_나이순정렬 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer(); 
		int N = Integer.parseInt(br.readLine());
		
//		int[] age = new int[N];
//		String[] name = new String[N];
		
		StringTokenizer st; 
		String[][] arr = new String[N][2];
		
		for(int i=0; i<N; i++) { //입력받음 
			st = new StringTokenizer(br.readLine()," ");
			arr[i][0]=st.nextToken();
			arr[i][1]=st.nextToken();
		}
		
//		String[] namecopy = Arrays.copyOf(name,N); //원래 배열을 카피해둠 (추후 가입순 판별하려고) 
		
		Arrays.sort(arr,new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
			
		});

		
		for(int i=0; i<N; i++) {
			sb.append(arr[i][0]+" "+arr[i][1]).append('\n');
		}
		System.out.println(sb);
		
	}
	
//	private static void swap(int[] age, String[] name, int i, int j) { //i번째 요소와 j번째 요소를 서로 바꿈 
//		int tmp1 = age[i];
//		String tmp2 = name[i];
//		age[i] = age[j];
//		name[i] = name[j];
//		age[j] = tmp1;
//		name[j] = tmp2;
//	}

	

}
