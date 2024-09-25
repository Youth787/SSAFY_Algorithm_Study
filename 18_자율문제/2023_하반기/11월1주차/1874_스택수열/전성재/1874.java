import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
// 만약 last부분을 1부터 시작하고 반복문을 j = last부터 시작하면 될까?ㅠ
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack =new Stack<>();
        int last = 0;
        for(int i=0; i<N;i++){
            int n = Integer.parseInt(br.readLine());
            if(n>last){
                for(int j=last+1; j<=n; j++){
                    stack.push(j);
                    sb.append("+\n");
                }
                last = n;
            }
            if(stack.get(stack.size()-1)==n){
                stack.pop();
                sb.append("-\n");
            }
            }
        if(stack.size()>0){
            System.out.println("NO");	
        }
        else {
        	System.out.println(sb);	
        }

        }
}
