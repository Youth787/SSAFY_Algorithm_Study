import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static void quickSort(int[] arr) {
		//정렬을 할 배열을 받아서, 시작 위치와, 끝나는 점을 정함
		quickSort(arr, 0, arr.length-1);
	}

	//재귀함수를 본격적으로 호출
	//배열의 포인터와 start, end 파티션을 나눌 range를 인자로 받음
	private static void quickSort(int[] arr, int start, int end) {
		//해당 배열방의 시작과 끝, 그 영역 안에서 파티션을 나누고
		//나눈 파티션에 오른쪽 방 첫번째 값을 받아옴
		int part2 = partition(arr, start, end);

		//오른쪽 파티션이 시작점 바로 다음에서 시작한다면, 왼쪽 파티션의 데이터가 하나뿐. 더이상 정렬할 필요가 없음 
		//오른쪽 파티션이 시작점에서 1개 이상이 차이가 날 때만 이 함수를 재귀적으로 호출
		if (start < part2-1) {
			//함수를 다시 호출할 때는 정렬을 할 배열 방의 시작과 끝점 다시 조정
			//끝나는 지점은 오른쪽 파티션의 시작점 바로 전으로 조정
			quickSort(arr, start, part2-1);
		}

		//오른쪽 파티션의 배열이 1개 이상일때만 호출해야 하니
		//오른쪽 파티션의 시작점이 마지막 배열방보다 작은 경우에만 오른쪽 파티션 정렬
		if (part2 < end) {
			//파티션 함수에서 받아온 오른쪽 파티션의 시작값으로 조정, 끝나는 지점은 처음에 받았던 range의 끝나는 값으로 quickSort 함수를 다시 호출
			quickSort(arr, part2, end);
		}
	}

	//배열방의 파티션을 나누는 함수. 인자로는 배열방의 주소와 파티션을 나눌 시작과 끝 방의 인덱스를 받음
	private static int partition(int[] arr, int start, int end) {
		//피벗 값은 배열방의 중간에 있는 값으로
		int pivot = arr[(start+end)/2];
		//시작점이 끝지점보다 작거나 같은 동안만 반복적으로 양쪽 끝에서 포인트를 한칸씩 앞으로 옮긴다
		while (start <= end) {
			//배열방의 값이 피벗 값보다 작으면 무시하고 계속 넘어갈 것
			while (arr[start]<pivot) {
				start++;
			}
			//크거나 같다면 그자리에 멈추고
			//이제는 end point가 움직임. 맨 뒤에서부터 배열 방의 값이 피벗 값보다 크면 무시하고 계속 건너뛰며 앞으로 이동.
			while (arr[end]>pivot) {
				end--;
			}
			//돌던 시작점과 끝점이 아직 서로 만났다가 지나치지는 않았는지 확인
			if (start <= end) {
				//두 개의 값을 스왑, start, end 포인터를 각각 뒤/앞으로 한칸씩 이동
				swap(arr, start, end);
				start++;
				end--;
			}

		}
		//결국 start와 end가 지나칠 때까지 반복되면 start 포인터에 새로 나눌 오른쪽 파티션의 첫번째 배열방 인덱스가 들어감. 그걸 반환.
		return start;

	}

	//swap함수 정의. 임시공간에 담았다가 옮기기
	private static void swap(int[] arr, int start, int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}

	//배열을 출력해주는 함수도 정의
	private static void printArray(int[] arr) {
		for (int data : arr) {
			System.out.println(data);
		}
	}




	public static void main(String args[]) throws IOException   {

		//InputStreamReader를 이용해 보조스트림 BufferedReader 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int [] arr = new int[N];

		String [] a = new String[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		quickSort(arr);
		printArray(arr);

	}


}
