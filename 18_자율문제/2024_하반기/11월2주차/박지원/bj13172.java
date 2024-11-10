//백준 Σ 자바
//수학,,, 사실 뭔소린지 모르겠음아직..
import java.util.*;
import java.io.*;

public class Main {
    private static final int P = 1000000007;
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st;
            long N = 1, S = 0;
            //기댓값 합 구하기
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine()," ");
                int n = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                //각 분모와 분자를 통분하여 계산
                S = s * N + S * n;
                N *= n;
                //모듈러 산술로 인하여 나머지 계산
                S %= P;
                N %= P;

            }
            if(S % N != 0)  //기약 분수일 때
                bw.write((search(N, P-2) * S) % P + "");
            else		//기약 분수가 아닐 때
                bw.write(S/N + "");
            bw.flush();
            bw.close();
            br.close();
        }
        //페르마 소정리, 모듈러 산술을 이용한 역원의 값 구하기
        static long search(long N, int index) {
            if(index == 1)
                return N;
            long temp = search(N, index/2);
            if(index % 2 == 1)
                return temp * temp % P * N % P;
            else
                return temp * temp % P;
    }
}
