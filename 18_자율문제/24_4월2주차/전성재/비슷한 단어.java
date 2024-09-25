import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static String standard;
    static int res = 0;
    static int[] alphabet = new int[26];
    static int[] check;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 기준값 알파벳 분석 : 알파벳 개수를 기록
        standard = br.readLine();
        for(int i=0;i<standard.length();i++){
            int idx = standard.charAt(i) - 'A';
            alphabet[idx]++;
        }

        // 나머지 값 분석
        for(int i=0;i<N-1;i++){
            check = alphabet.clone();
            String curr = br.readLine();

            // 길이 차이가 1 넘을 경우 같은 수가 될 수 없음
            if(Math.abs(curr.length() - standard.length())>1) continue;

            // cnt = 기준값과 같은 알파벳의 개수
            int cnt = 0;

            // 비교할 문자열의 알파벳 비교
            for(int j=0;j<curr.length();j++){
                int idx = curr.charAt(j) - 'A';

                // 만약 비교할 문자열의 알파벳이 기준 알파벳에도 존재할 때마다 값 증가
                // 이 때 중복 체크 방지하기 위해서 check 배열값 감소
                if(check[idx]>0){
                    cnt++;
                    check[idx]--;
                }
            }

            // 조건 비교
            // 1. 기준값보다 길이가 1만큼 작을 경우
            if(standard.length()-1 == curr.length()){
                // 현재값이 기준값에 존재하는 알파벳과 다른 알파벳을 가지고 있으면 안됨
                // 즉 현재값에서 기준값과 같은 알파벳의 개수(cnt)와 현재값의 길이(curr.length())가 같으면 만족
                if(cnt == curr.length()) res++;
            }

            // 2. 기준값보다 길이가 1만큼 클 경우
            else if(standard.length()+1 == curr.length()){
                // 값을 하나 빼도 기준값의 알파벳 구성과 같아야 함
                // 즉 현재값에서 기준값과 같은 알파벳의 개수(cnt)와 기준값의 길이(standard.length())가 같으면 만족
                if(cnt == standard.length()) res++;
            }

            // 3. 기준값과 길이가 같을 경우
            else if(standard.length() == curr.length()){
                // case 1. 현재값에서 기준값과 같은 알파벳의 개수(cnt)가 기준값의 길이(standard.length())가 같으면 만족
                if(cnt == standard.length()) res++;

                // case 2. 현재값에서 기준값과 같은 알파벳의 개수(cnt)가 기준값의 길이(standard.length())보다 1 작다면 만족
                else if(cnt == standard.length()-1) res++;
            }

        }

        System.out.println(res);
    }
}
