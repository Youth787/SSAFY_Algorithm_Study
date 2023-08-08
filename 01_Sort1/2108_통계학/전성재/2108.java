import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        int c = 0;
        int d = 0;
        
        // 배열에 입력값 넣기
        for (int i = 0; i < N; i++) {
            arr[i] = (Integer.parseInt(br.readLine()));
            sum += arr[i];
        }
        // 산술평균
        int avg = (int)Math.round((double)sum / N);
        
        // 중앙값
        Arrays.sort(arr);
        int mid = arr[N/2];
        
        // 최빈값
        int[] plus = new int[4002];
		int[] minus = new int[4001];
		for(int i = 0; i < N; i++) {
			if(arr[i] < 0) {
				minus[Math.abs(arr[i])]++;
			}
			else {
				plus[arr[i]]++;
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		
		// 가장 높은 빈도수 체크
		int max = 0;
		for(int i=0; i<plus.length;i++) {
			max = Math.max(max, plus[i]);
			
		}
		for(int i=0; i<minus.length;i++) {
			max = Math.max(max, minus[i]);
		}
        
		for(int i : arr) {
			if(i<0) {
				if(minus[Math.abs(i)] == max && !(list.contains(i))) {
					list.add(i);
				}
			}
			else {
				if(plus[i] == max && !(list.contains(i))) {
					list.add(i);
				}
				
			}
		}
        
		// 2개 이상이면 2번째로 작은 것 출력
				if(list.size()>=2) {
					c = list.get(1);
				}
				// 1개면 그대로
				else {
					c = list.get(0);
				}
		
				
			// 범위
			d = arr[N-1] - arr[0];
			
			System.out.println(avg);
			System.out.println(mid);
			System.out.println(c);
			System.out.println(d);

        
    }
}
