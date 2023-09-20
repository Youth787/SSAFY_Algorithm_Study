import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//[문제] 0 1 ... n번째 피보나치 수 출력
//[입력] n(20보다 작거나 같은 자연수 또는 0)

public class Main {
	      public static void main(String[] args) throws NumberFormatException, IOException {
    
		            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		            int n = Integer.parseInt(br.readLine());
		            System.out.println(fbnc(n));

	      }

        //피보나치 0 1 1 2 3 5 8 ...
	      public static int fbnc(int n) {
		            if (n == 0) 	return 0; 
		            if (n == 1) 	return 1;  
                else  return fbnc(n - 1) + fbnc(n - 2); 
                //n=3이면 0 + 1 = 1, n=4이면 (3)+(2) = {(2) + (1)} + {(1) + (0)} = { (1) + (0) } + 1 + 1 + 0 = 3 ...
        }
}
