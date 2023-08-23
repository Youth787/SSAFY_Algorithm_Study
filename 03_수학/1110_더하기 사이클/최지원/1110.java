
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner (System.in);
		int N = sc.nextInt();

		//일단 처음 시도는 여기서 했음
		int num1 = N%10; //원래 받은 숫자에서 일의 자리(10으로 나눴을 때의 나머지)
		int num2 = N/10 + num1; //각 자리수 합(10으로 나누었을때의 몫 (십의 자리 숫자)+ 일의 자리 숫자)
		int num3 = (num1*10)+num2%10; //num1과 num2의 일의자리를 서로 연결한다
		int cnt = 0;
		if (num3 == N) {
			System.out.println(1); //사실 0인 경우 때문에 껴놓은 부분
		} else {
			while (num3 != N ) {
				cnt++;
				num1 = num3%10; //새롭게 나왔던 숫자의 1의자리 숫자 (10으로 나눴을 때의 나머지)
				num2 = num3/10 +num1;
				num3 = num1*10 + num2%10;

				if (num3 == N) { //만약 위의 과정을 마치고 새롭게 나온 숫자 num3가 원래 숫자 N이랑 같아졌다면
					cnt++;	//그자리에서 바로 cnt를 하나 더하고
					break; //끝!!
				
				}

			}
			System.out.println(cnt);
		}
	}

}

/*
유클리드 호제법(유클리드 알고리즘)
2개의 자연수의 최대공약수를 구하는 알고리즘.
(a > b일 때) a % b = r이면, a와 b의 최대공약수 = b와 r의 최대공약수
(a % b = r)
b % r = r'
r % r'=r''
...
나머지가 0이 되었을 때의 r이 a와 b의 최대공약수

ex.
a = 26 , b = 12
26 % 12 = 2
12 % 2 = 0 => 나머지가 0이 되었으니 26과 12의 최대공약수는 2.
(2 % 0)


알고리즘으로 구현하면

public static int gcd(int p, int q)  { //이 때 p > q이어야 함)
  if (q == 0)  {  //위의 26, 12 예시에서 2 % 0(q) 인 상황.
    return p; // 최대공약수 p 리턴
  }
  return gcd(q, p%q); //q가 0이 아니라면 다시 q와 'p를 q로 나눈 나머지'를 두고 반복
}


최소공배수 : 두 수의 최대공약수 * 두 수의 나머지들
두 수 곱/최대공약수 

*/
