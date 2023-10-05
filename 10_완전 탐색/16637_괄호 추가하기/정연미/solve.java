package 완전탐색;
import java.io.*;
//https://kwoncorin.tistory.com/131

public class 괄호추가하기  {
    public static int length;
    public static char[] expression;
    public static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        length = Integer.parseInt(br.readLine());
        expression = br.readLine().toCharArray();

        makeExpression(2, expression[0] - '0');
        bw.write(String.valueOf(MAX));
        bw.flush();
    }

    public static void makeExpression(int now,int total) {
        // 종료 조건
        if(now>=length){
            MAX = Math.max(MAX, total);
            return;
        }

        // 괄호를 사용하지 않음 A+B
        makeExpression(now + 2, calculate(total, expression[now] - '0', expression[now - 1]));

        // now부터 시작하는 괄호를 사용함. A+(B+C)
        if(now+2<length){
            int sum = calculate(expression[now] - '0', expression[now + 2] - '0', expression[now + 1]);
            int sumTotal = calculate(total, sum, expression[now - 1]);
            makeExpression(now + 4, sumTotal);
        }
    }

    // 계산 결과 반환
    public static int calculate(int sum, int plus, char sep) {
        if(sep=='+')
            return sum + plus;
        if(sep=='-')
            return sum - plus;
        return sum * plus;
    }
}