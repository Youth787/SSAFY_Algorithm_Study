package Algo_스터디.Jan_4주차;

// https://tussle.tistory.com/1000

import java.io.*;
public class 별찍기11_2448 {
    static String[] star;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        star = new String[N];
        //별 기본 모양 저장! k = 0
        star[0] = "  *  ";
        star[1] = " * * ";
        star[2] = "*****";
        //별 찍기 진행!
        for(int i=1; 3 * Math.pow(2, i) <= N;i++)
            writeStar(i);

        //별 찍기 결과 BufferedWriter 저장
        for(int i=0;i<N;i++)
            bw.write(star[i] + "\n");

        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //k값 점화식을 통한 별 찍기 진행
    static void writeStar(int i) {
        int bottom = (int) (3 * Math.pow(2, i));	//아래 최대 행
        int middle = bottom/2;	//위와 아래를 구분하는 행
        //아래 부분 대응하는 별 점화식 적용
        for(int j=middle;j<bottom;j++)
            star[j] = star[j-middle] + " " + star[j-middle];
        String blank = " ".repeat(middle);
        //위 부분 대응하는 별에 빈 칸 추가!
        for(int j=0;j<middle;j++)
            star[j] = blank + star[j] + blank;
    }
}