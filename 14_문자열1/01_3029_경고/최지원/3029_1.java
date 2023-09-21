package p3029_경고;
//[문제] 현재 시간과 정인이가 던질 시간이 주어졌을 깨, 정인이가 얼마나 숨어있어야 하는지?
//답 범위 = 1초~24시간
//[입력] 첫 줄 : 현재 시간 hh:mm:ss형식/ 둘째 줄 : 던질 시간이 똑같은 형식으로
//시간이니까 0<=hh<=23, 0<=mm<=59, 0<=ss<=59겠쥬

import java.util.Arrays;
import java.util.Scanner;

//단순히 던질 시간이 더 큰 경우는 둘을 빼면 되고
//만약 던질 시간이 더 작은 경우면 다음날이라고 생각하고 계싼
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] nowTmp = sc.nextLine().split(":"); //[0]에는 시 [1]분 [2]초
		String [] throwTmp = sc.nextLine().split(":");
		int [] nowT = new int [3];
		int [] throwT = new int [3];
		for (int i = 0; i<3 ; i++) {
			nowT[i] = Integer.parseInt(nowTmp[i]);
			throwT[i] = Integer.parseInt(throwTmp[i]);
		}

		int [] ansT = new int [3]; 

		//다음날 던진다면 
		if (nowT[0] > throwT[0] || (nowT[0] == throwT[0] && nowT[1] > throwT[1]) || (nowT[0] == throwT[0] && nowT[1] == throwT[1] && nowT[2] > throwT[2])) {
			int [] tmpT = {24, 0, 0};
			//초 부터 계산하면서 부족하면 끌어온다
			if (tmpT[2]==nowT[2]) ansT[2] = throwT[2];//지금 0초면 그냥 다음날 초만 더해줘
			else {
				tmpT[1] -= 1;//1 분 끌어와
				ansT[2] = (tmpT[2]+60- nowT[2]) + throwT[2] ;//60초를 더한 상황에서 빼
			}
			//똑같은 방법으로 분 계산하자
			if (tmpT[1]==nowT[1]) ansT[1] = throwT[1];
			else {
				throwT[0] -= 1;//1 시간 끌어와
				ansT[1] = (tmpT[1]+60- nowT[1]) + throwT[1] ;//60분을 더한 상황에서 빼
			}
			ansT[0] = (tmpT[0]-nowT[0]) +throwT[0];//시는 일단 무조건 뺄 수 밖에
		}

		//당일에 던진다면(시 차이 or 시= 분 차이 or 시= 분= 초 차이)
		else if (nowT[0] < throwT[0] || (nowT[0] == throwT[0] && nowT[1] < throwT[1]) || (nowT[0] == throwT[0] && nowT[1] == throwT[1] && nowT[2] < throwT[2])) {
			//초 부터 계산하면서 부족하면 끌어온다
			if (throwT[2]>=nowT[2]) ansT[2] = throwT[2]-nowT[2];
			else {
				throwT[1] -= 1;//1 분 끌어와
				ansT[2] = throwT[2]+60 - nowT[2];//60초를 더한 상황에서 빼
			}
			//똑같은 방법으로 분 계산하자
			if (throwT[1]>=nowT[1]) ansT[1] = throwT[1]-nowT[1];
			else {
				throwT[0] -= 1;//1 시간 끌어와
				ansT[1] = throwT[1]+60 - nowT[1];//60분을 더한 상황에서 빼
			}
			ansT[0] = throwT[0]-nowT[0];//시는 일단 무조건 뺄 수 밖에
		}// 당일에 던질 때 계산
		else if (nowT[0] == throwT[0] && nowT[1] == throwT[1] && nowT[2] == throwT[2]) {
			ansT[0] = 24; ansT[1] = 0; ansT[2] = 0;
		}
		
		//60이상의 분, 초가 없게 확인
		if (ansT[2]>=60) {
			ansT[2] = ansT[2] -60;
			ansT[1] += 1;
		}
		if (ansT[1]>=60) {
			ansT[1] = ansT[1] -60;
			ansT[0] += 1;
		}

		//다시 형식대로 출력하게 : String.format : %.채워질문자.총자리수.d
		System.out.println(String.format("%02d:%02d:%02d", ansT[0], ansT[1], ansT[2]));
	}//main
}//class
