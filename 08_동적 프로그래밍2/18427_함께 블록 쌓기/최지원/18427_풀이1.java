// https://dingdingmin-back-end-developer.tistory.com/entry/%EB%B0%B1%EC%A4%80-18427%EC%9E%90%EB%B0%94-java-%ED%95%A8%EA%BB%98-%EB%B8%94%EB%A1%9D-%EC%8C%93%EA%B8%B0
import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int h = Integer.parseInt(s[2]);
        //학생 수 n, 최대로 가진 블록 수 m, 목표 높이 h 입력받음
        int [][] dp = new int[n+1][1001];//2차원 dp배열. 사이즈는 [학생 수 +1][h의 최대 1000 +1] 
 
        List<Integer>[] list = new ArrayList[n+1]; // n+1 사이즈로 list 생성

        //학생들이 가진 블록 높이들 저장하는 곳
        for(int i=1; i<=n; i++){ //학생은 1번부터, n번까지 있음
            list[i] = new ArrayList<>(); //list의 i번째에 새로운 arrayList 생성함
            StringTokenizer st = new StringTokenizer(br.readLine()); //한 학생마다 한줄을 읽어서 StringTokenizer로 갖고있고,
            while(st.hasMoreTokens()){ //hasMoreTokens()는 남은 토큰이 있는지를 boolean값으로 반환하기 때문에 while문의 조건에 넣고
                list[i].add(Integer.parseInt(st.nextToken()));//list의 i번째 arrayList에 블록 높이 add하는 과정
            }//한사람이 가진 블록 정보 다 저장
        }//모든 학생 돌면서 정보 다 저장함
 
        for(int i=0; i<=n; i++){
            dp[i][0]=1;//i번째 학생이 높이 0만큼 쌓는 경우의 수는 1이다 
            //높이가 0인 경우에도 1가지 경우로 취급하더라...
        }

        //for문 구조 : (1)학생 안에 (2)높이 안에 (3)(한 학생이 가진)블록들
        for(int i=1; i<=n; i++){ //모든 학생을 도는 for문
            for(int j=1; j<=h; j++){ //모든 높이를 도는 for문
                for(Integer integer: list[i]){ //학생 i가 가진 모든 블록들을 도는 for문
                    if(j>=integer){ //블록을 더 쌓을 수 있다면...여기서는 각 블록 높이가 integer고, 현재의 목표 높이가 j. 
                        dp[i][j] += dp[i-1][j-integer];//그 전 학생까지 고려했을 때의, 그 전 높이까지의 값(경우의 수)를 현재에 더한다.
                        dp[i][j] %=10007; //dp에는 10007로 나눈 나머지를 미리 계산하여 저장한다. (나중에 답 출력 시 나누는게 아니라)
                    }//블록 쌓을 수 있는지 확인하는 if문
                }//한 학생이 가진 모든 블록을 도는 for문
                dp[i][j] += dp[i-1][j]; //현재 dp값에 이전 학생(i-1)까지 고려했을 때 높이 j를 만들 수 있는 경우의 수를 더한다.
                dp[i][j] %=10007;//그리고 또 나머지로 저장
            }//높이 도는 for문
        }//학생 도는 for문
        System.out.println(dp[n][h]); //다 돌았다면 dp[n][h] 안에는 (h높이를 만들 수 있는 모든 경우의 수)%10007이 저장되어 있음!
    }//main
}//class
