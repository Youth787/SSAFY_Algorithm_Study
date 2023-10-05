/*
  문제 : 왼쪽부터 차례로 계산해야 하는, 길이가 n인 수식에 괄호를 적절히 추가해 만들 수 있는 식의 결과 최대값
  - 수식은 0~9 정수와 우선순위 동일한 연산자 + - * 로 구성)
  - 괄호를 통해 우선순위 부여(단 괄호 안에는 연산자 하나만 들어 있어야 하며, 중첩된 괄호는 사용 불가)

  입력 : 첫 줄 n(수식 길이) / 둘째 줄 정수로 시작하여 연산자와 정수가 번갈아 가며 나오는 수식
  
*/

/*
풀이 1 : DFS, 백트래킹 사용
이전의 연산 결과를 순서대로 계산하거나,
이전의 연산 결과 오른쪽에 있는 2개의 값을 괄호로 처리하여 계산하고 이전의 연산 결과와 합치는 두 가지 경우의 재귀
https://steady-coding.tistory.com/36
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
 
public class Main {
    static int ans;
    static ArrayList<Character> ops;
    static ArrayList<Integer> nums;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
 
        ops = new ArrayList<>();
        nums = new ArrayList<>();
 
        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                ops.add(c);
                continue;
            }
            nums.add(Character.getNumericValue(c));
        }
 
        ans = Integer.MIN_VALUE;
        DFS(nums.get(0), 0);
 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
    // 연산
    public static int calc(char op, int n1, int n2) {
        switch (op) {
        case '+':
            return n1 + n2;
        case '-':
            return n1 - n2;
        case '*':
            return n1 * n2;
        }
        return -1;
    }
 
    // DFS, 백트래킹 활용.
    public static void DFS(int result, int opIdx) {
        // 주어진 연산자의 개수를 초과하였을 경우.
        if (opIdx >= ops.size()) {
            ans = Math.max(ans, result);
            return;
        }
 
        // 괄호가 없는 경우
        int res1 = calc(ops.get(opIdx), result, nums.get(opIdx + 1));
        DFS(res1, opIdx + 1);
 
        // 괄호가 있는 경우
        if (opIdx + 1 < ops.size()) {
            // result의 오른쪽에 있는 값을 연산함.
            int res2 = calc(ops.get(opIdx + 1), nums.get(opIdx + 1), nums.get(opIdx + 2));
 
            // 현재 result와 방금 구한 괄호 값을 연산한 결과와 괄호 오른쪽에 존재하는 연산자의 인덱스를 넘김.
            DFS(calc(ops.get(opIdx), result, res2), opIdx + 2);
        }
    }
 
}

/*
풀이 2 : DFS 사용
인덱스가 홀수일 땐 연산자, 짝수일 땐 숫자가 들어옴을 이용하여 숫자와 연산자를 따로 저장함
https://suhyeokeee.tistory.com/76
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
​
public class Main {
    static int n;
    static int max = Integer.MIN_VALUE;
    static ArrayList<Integer>num = new ArrayList<>();
    static ArrayList<Character> op = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
​
         n = Integer.parseInt(br.readLine());
         
         String t = br.readLine();
         for(int i=0; i<n; i++) {
             if(i%2==0) {
                 num.add(t.charAt(i)-'0');
             }
             else {
                 op.add(t.charAt(i));
             }
         }
         int start = num.get(0);
         dfs(0,start);
         System.out.println(max);
    }
    public static void dfs(int now, int sum) {
        if(now>=op.size()) {
            max = Math.max(max, sum);
            return;
        }
        // 1. 괄호 안치고 진행하기
        int one = cal(now, sum, num.get(now+1));
        dfs(now+1, one);
        // 2. 괄호 치고 진행하기
        if(now+1 < op.size()) { // 인덱스 범위 오류를 제거하기 위해
            int two = cal (now+1, num.get(now+1), num.get(now+2));
            int result = cal (now, sum, two);
            dfs(now+2, result);
        }
   }
    public static int cal(int op_idx,int a, int b) {
        switch(op.get(op_idx)) {
        case '+':
            return a+b;
        case '-':
            return a-b;
        case '*':
            return a*b;
        }
        return 1;
    }
}
​
​/*
풀이 3 : 완전탐색 재귀?
2번째 수부터 시작하여(인덱스 2~) 괄호 추가하거나(지금까지의 결과 & 오른쪽 숫자에 대한 괄호 치기), 추가하지 않거나(지금까지의 결과 계산)
https://sigidev.tistory.com/38
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준 {
	static int N, result;
	static char[] input;

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 80ms
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		input = new char[N];

		input = br.readLine().toCharArray();

		result = Integer.MIN_VALUE;
		// 2번 인덱스의 숫자 (2번째 숫자)부터 괄호를 내 왼쪽에 칠건지(결국 안치는게 됨) 오른쪽에 칠건지 치지 않을건지
		solve(2, input[0] - '0');
		System.out.println(result);
	}

  //인자로 현재 숫자의 인덱스값, 현재까지의 (합)결과
	private static void solve(int i, int sum) {
		
		if (i >= N) {
			result = Math.max(result, sum);
			return;
		}
		
		// 괄호 안 친 경우 지금까지의 합과 나를 계산한 결과를 다음 숫자 (index는 +2)에 넘긴다
		solve(i+2, cal(sum, input[i]-'0', input[i-1]));
		
		// 오른쪽에 괄호 친 경우
		if (i + 2< N) {
			// 옆 괄호 먼저 계산
			int right = cal(input[i]-'0', input[i+2]-'0' , input[i+1]);
			// 지금까지 결과와 합하기
			int left = cal(sum, right, input[i-1]);
			solve(i+4, left);
		}
	}

  //연산자에 따른 계산
	private static int cal(int i, int j, char op) {
		if (op == '+')
			return i + j;
		else if (op == '-')
			return i - j;
		else
			return i * j;
	}
}
​
