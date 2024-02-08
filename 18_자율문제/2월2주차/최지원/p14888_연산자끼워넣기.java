import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * n개의 수로 이루어진 수열(순서 고정), n-1개의 연산자(사칙연산)로 만들 수 있는 최대값과 최소값 구하기
 * 식의 계산은 연산자 우선순위를 무시하고 "앞에서부터 진행", 나눗셈은 몫만
 * 음수를 양수로 나누면 (양수로 바꾸고 몫을 구한 뒤 음수로 바꾸기)
 * 
 */

public class Main {

    static int N ; //수 개구
    static int[] number;
    static int[] operator = new int[4]; //연산자 개수
    static int MAX = Integer.MIN_VALUE;	// 최댓값
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    } //main

    public static void dfs(int num, int idx) {
        if (idx == n) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) { //연산자 종류별로
            if (operator[i] > 0) { //연산자가 아직 남았다면

                operator[i]--; //해당 연산자 개수 --
                switch (i) {
                    case 0: 
                        dfs(num + number[idx], idx + 1);   
                        break;
                    case 1:	
                        dfs(num - number[idx], idx + 1);   
                        break;
                    case 2:	
                        dfs(num * number[idx], idx + 1);   
                        break;
                    case 3: 
                        dfs(num / number[idx], idx + 1);   
                        break;
                } //재귀호출
                operator[i]++; //재귀 종료되면 해당 연산자 개수 복구
            }
        }
    } //dfs
} //class
