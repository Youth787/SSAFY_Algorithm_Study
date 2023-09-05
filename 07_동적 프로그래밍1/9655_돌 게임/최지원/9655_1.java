import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//[문제] 두 사람이 돌 n개를 번갈아가며 1 또는 3개 가져갈 때 마지막 돌을 가져가는 사람이 누구인지
//[출력] 상근이 SK, 창영 CY 
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); //돌 개수
		
		if (n%2 ==1) System.out.println("SK");
		else System.out.println("CY");
	}

}
test
