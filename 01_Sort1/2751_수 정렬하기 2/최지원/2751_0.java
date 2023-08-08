public class Main  {
  //mergeSort 함수를 정의 하고 배열을 인자로 받는다
	private static void mergeSort(int[] arr) {
		//임시 저장 공간 필요=배열의 크기만큼
		int[] tmp = new int[arr.length];
		//정리할 배열, 임시 저장 공간, 시작, 끝 인덱스 갖고 재귀호출
		mergeSort(arr,tmp, 0, arr.length-1);
	}
	
	//재귀호출
	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		//시작 인덱스가 끝 인덱스보다 작은 경우에만 재귀호출
		if (start < end) {
			//배열을 딱 가운데를 나눠야 하니까 가운데 인덱스 필요
			int mid = (start+end)/2;
			mergeSort(arr,tmp,start,mid); //시작 인덱스~가운데 인덱스 호출
			mergeSort(arr,tmp,mid+1,end); //가운데 인덱스+1~끝 인덱스 호출
			
			//가운데를 기준으로 왼 오른쪽 배열방의 정렬된 상태
			merge(arr,tmp,start,mid,end); //두 배열을 병합
		} 
	}
	
	//merge
	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		//임시 저장 공간에 정렬된 배열을 필요한 만큼 복사
		for (int i = start;i<=end; i++) {
			tmp[i] = arr[i];
		}
		int part1 = start; //첫 배열 방의 첫 인덱스
		int part2 = mid+1; //두번째 배열 방의 첫 인덱스
		
		//작은 값을 하나씩 복사할 때마다 결과 배열방의 어디에 저장해야 하는지
		int index = start;
		
		//첫번째 배열이 끝까지 가거나, 두번째 배열이 끝까지 갈 때까지 돌린다
		while (part1 <= mid && part2 <= end) {
			//두개 배열의 첫 값중 작은 것을 옮기고, 앞쪽 포인터를 하나 뒤로 옮긴다
			if (tmp[part1]<=tmp[part2]) {
				arr[index] = tmp[part1];
				part1++;
			}	else {
				arr[index] = tmp[part2];
				part2++;
			}
			index++; //어떤 곳에서 옮겼든 인덱스는 +1해줘야함
		}
		
		//포인터가 배열의 끝에서 남은 만큼을 돌면서 최종 배열에 붙여준다
		//뒤쪽 데이터가 남는 것은 신경 안써도 됨, 신경 쓸 것은 앞 데이터가 남는 상황
		for (int i = 0; i <= mid - part1; i++) {
			arr[index +1] = tmp[part1+i];
		}
		
	}
	
	//프린트하는 함수 정의
	private static void printArray(int[] arr) {
		for (int data : arr) {
			System.out.println(data + ", ");
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		int [] arr = {3,9,4,7,5,0,1,6,8,2};//정렬 안된 배열 선언
		mergeSort(arr);
		printArray(arr);

	}

}
