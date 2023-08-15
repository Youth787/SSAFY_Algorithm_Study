import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * [문제] 2차원 평면 위의 점 N개를 y좌표 오름차순, x좌표가 같으면 x좌표 오름차순으로 정렬하고 출력
 * [입력] 첫 줄에 점 개수 N, 이후부터 N개의 줄에 점의 x, y 좌표
 * [조건] 좌표는 -100000~100000 항상 정수, 위치가 같은 두 점은 없음. 
 * */

//11650과 같은 방식, 람다식 부분에서 처음 비교값만 x좌표 값(arr[i][0])에서 y좌표 값(arr[i][1])으로 바꿈

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 사용
		int N = Integer.parseInt(br.readLine()); //몇 개의 점의 좌표가 나오는지 N에 저장
		
		int [][] arr = new int [N][2]; //좌표들을 저장할 점 N개*두 좌표(x,y) 크기의 arr 생성
		
		StringTokenizer st; //StringTokenizer 사용
		
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine()); //BufferedReader로 다음 줄을 읽어서 StringTokenizer를 사용하겠다
			
			arr[i][0] = Integer.parseInt(st.nextToken()); //arr[i][0]에는 x좌표를
			arr[i][1] = Integer.parseInt(st.nextToken()); //arr[i][1]에는 y좌표를 저장한다
		}

    //크기를 비교해 정렬하는 람다식 활용 
		Arrays.sort(arr, (e1, e2)->{ //arr에서 e1과 e2를 비교하겠다?
			if (e1[1] == e2[1]) { //y좌표가 같다면 
				return e1[0]-e2[0]; //x좌표끼리 비교하고
			} else {
				return e1[1]-e2[1]; //y좌표가 다르면 둘이 비교하겠다
			}
		});

    //StringBuilder를 사용하여 정렬된 arr의 값들을 더하는 과정
		StringBuilder sb = new StringBuilder();
		for (int i=0; i <N ; i++) {
			sb.append(arr[i][0]+" "+arr[i][1]).append('\n');
		}

		System.out.println(sb); //출력
		
	}

}
