//이클립스에서는 잘 돌아가는데 백준에서는 틀리다고 함?-?
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//저장
		String [] st = br.readLine().split("");
		int [] a = new int [st.length];
		for (int i=0; i<st.length; i++) {
			a[i] = Integer.parseInt(st[i]);
		}
 
		//버블 정렬 사용
		for (int i=0; i<a.length-1;i++) {//뒤로가면서 한번씩 돌꺼임 0~a.length-1
			for (int j=0; j<a.length-1;j++) { //j는 i(0)부터..
				if (a[j]<a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] =temp;
				}

			}
		}
		
		//출력
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}


	}

}
