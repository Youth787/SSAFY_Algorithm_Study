package m2w2;
import java.util.*;
import java.io.*;

//1232. [S/W 문제해결 기본] 9일차 - 사칙연산
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141J8KAIcCFAYD&
public class Solution1232 { 

	public static int N;
    public static int[][] tree;
    public static String[] value;
    public static Stack<Double> stack;
    
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int tc = 10; 
		for (int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			tree = new int[N+1][2]; //왼쪽자식, 오른쪽자식
            value = new String[N+1]; //트리의 원소
            stack = new Stack<Double>(); //숫자와 계산한 값을 담을 스택
             
            for (int i=1; i<=N; i++) {
                String[] temp = sc.nextLine().split(" ");
                if (temp.length == 4) { //노드에 자식이 있으면 tree에 자식 넣음
                    tree[i][0] = Integer.parseInt(temp[2]); //왼쪽 자식
                    tree[i][1] = Integer.parseInt(temp[3]); //오른쪽 자식
                }
                value[i] = temp[1]; //트리의 원소를 담음(숫자, 연산자)
            }
             
            postOrder(1);
            int result = (int)(Math.round(stack.pop()));
            System.out.printf("#%d %d\n",t, result);
		}
	}
	
    private static void postOrder(int i) { //후위순회 
        if (i != 0) {
            postOrder(tree[i][0]); //L
            postOrder(tree[i][1]); //R
            
            if (value[i].equals("+") || value[i].equals("-") || //연산자면 계산
            		value[i].equals("*") || value[i].equals("/") ) calc(value[i]);
            else stack.push(Double.parseDouble(value[i])); //숫자면 스택에 추가
        }
    } 
    
    private static void calc(String operator) {
        double right = stack.pop(); 
        double left = stack.pop();  
         
        if (operator.equals("+")) { 
            stack.push(left + right);
        } else if (operator.equals("-")) {
            stack.push(left - right);
        } else if (operator.equals("*")) {
            stack.push(left * right);
        } else if (operator.equals("/")) {
            stack.push(left / right);
        }
    } 
}
