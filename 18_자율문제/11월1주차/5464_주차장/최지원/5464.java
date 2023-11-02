//푸는 중
package p5464_주차장;
// https://www.acmicpc.net/problem/5464
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//문제: 주차 공간별 요금과 차량들의 무게와 출입 순서가 주어질 때, 오늘 하룻동안 주차장이 벌어들일 총 수입을 계산
// 대기장소는 큐(queue)
//만일 빈 주차 공간이 하나만 있거나 또는 빈 주차 공간이 없다가 한 대의 차량이 주차장을 떠나면 곧바로 그 장소에 주차를 하게 한다. 
//만일 빈 주차 공간이 여러 곳이 있으면, 그 중 번호가 가장 작은 주차 공간에 주차하도록 한다. 
//만일 주차장에 여러 대의 차량이 도착하면, 일단 도착한 순서대로 입구의 대기장소에서 줄을 서서 기다려야 한다. 
//주차료=(차랑의 무게)*(주차 공간마다 따로 책정된 단위 무게당 요금)

public class Main {
	static int n, m;//주차공간 수 n, 차량 수 m
	static boolean [] visitedN, visitedM;//
	static int [] Rs, Wk;//주차 공간 s의 단위 무게당 요금, 차량 k의 무세 저장하는 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());//주차공간 수 n
		m = Integer.parseInt(st.nextToken());//차량 수 m
		
		Rs = new int [n];
		for (int i = 0; i < n; i++) Rs[i] = Integer.parseInt(br.readLine());
		Wk = new int [m+1];//차 번호는 1번부터니까
		for (int i = 1; i <= m; i++) Wk[i] = Integer.parseInt(br.readLine());
		
		//음수면 나가는 경우, 양수면 들어오는 경우
		
		
	}//main
}//class
