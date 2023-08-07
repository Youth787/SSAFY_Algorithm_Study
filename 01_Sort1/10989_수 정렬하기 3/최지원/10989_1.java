//시간초과 고려1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//입력값에 나올 수 있는 자연수 범위만큼의 배열을 만들고 등장 횟수를 배열에 저장하는 방식으로 풀이
public class Main{
    public static void main (String[] args) throws IOException {
    //IOException은 입출력 예외처리
        
        //문자형의 입력값을 읽기 위해 br 생성
        //InputStreamReader를 생성하고 (Input은 byte형, Reader는 문자형, 이들을 연결한다)
        //이를 통해 보조스트림 BufferedReader 생성하는 방식(스트림을 보조하는 역할)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //이후에 몇 개의 자연수가 나오는지를 다음줄을 문자열로서 읽고
        //int로 형변환해서 n에 저장
        //BufferedReader는 다음줄을 문자열로 읽는 readLine()를 갖고 있음
        int n = Integer.parseInt(br.readLine());
        
        //나올 수 있는 자연수의 범위만큼의 int배열 생성
        //인덱스가 0부터이므로 10000을 포함하려면 크기는 10000+1
        int [] cnt = new int[10001];
        
        //다음 줄을 BufferedReader의 readLine으로 읽음 & 형 변환
        //cnt[읽은 자연수]값을 +1
        //n번 반복함
        for (int i = 0; i < n; i++){
            cnt[Integer.parseInt(br.readLine())]++;
        }
        
        //다끝났다면 BufferedReader 종료
        br.close();
        
        //출력할 문자열을 담기 위해 sb 생성
        StringBuilder sb = new StringBuilder();
        
        //i= 1~10000까지 돌면서 cnt에서 0보다 큰 값을 가진 인덱스(한번 이상 나온 숫자) 출력
        //sb에 append로 i 추가, 줄바꿈 \n도 추가
        //한번 출력하면 그 인덱스 속 cnt값을 -1함
        //cnt[i]값이 0이 되기 전까지 반복 (while)
        for (int i = 1; i < 10001; i++){
            while (cnt[i]>0){
                sb.append(i).append("\n");
                cnt[i]--;
            }
        }
        
        //sb에 저장 다 끝났으면 출력
        System.out.println(sb);
    }
}
