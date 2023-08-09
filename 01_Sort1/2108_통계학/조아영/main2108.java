import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class main2108 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		
		int[] arr = new int[size];
		
		for (int i=0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		
		//산술평균
		
		int sum = 0; 
		
		for (int i=0; i<size; i++) {
			sum = sum + arr[i];
		}
		
		int mean = (int) Math.round(( (double) sum / (double) size ));
		

		
		//중앙값
		
		int[] arrcopy = Arrays.copyOf(arr, size);
		
		Arrays.sort(arrcopy);
		
		int median = arrcopy[size/2];
		
		
		//최빈값
		int[] frequency = new int[size];
		
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				
				if (arr[i]==arr[j]) {
					frequency[i]++;
				}
				
			}
		}
				
//		System.out.println("빈도수 배열:"+Arrays.toString(frequency));

		int maxf = 0; 
		
		for (int i=0; i<size; i++) {
			if (maxf < frequency[i]) {
				maxf = frequency[i];
			}
		}
		
		//최빈값인 애들 리스트에 넣음 (근데 중복인 애들도 막 들어갈것) 
		List<Integer> temp = new ArrayList<>();
		for (int i=0; i<size; i++) {
			if (frequency[i]==maxf) {
				temp.add(arr[i]);
			}
		}
		
		//리스트를 Set으로 변경. Set은 중복을 허용하지 않으므로 중복이 자연스레 제거됨 
		Set<Integer> temp2 = new HashSet<Integer>(temp);
		
		//Set을 다시 리스트로 변경
		List<Integer> temp3 = new ArrayList<Integer>(temp2);
		
		int mod = 0;
		
		if (temp3.size()!=1) {
			Collections.sort(temp3);
			mod = temp3.get(1);
			
		} else {
			mod = temp3.get(0);
		}
		
		//범위
		
		int range= arrcopy[size-1]-arrcopy[0]; //최댓값-최솟값
		
		
		//출력
		System.out.println(mean);
		System.out.println(median);
		System.out.println(mod);
		System.out.println(range);

	}

}
