import java.util.*;
import java.io.*;

public class Solution1224 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 10;
        for(int t = 1; t <= tc; t++) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine(); 
            Stack<Character> tmp = new Stack<>();
            for(int i = 0; i < N; i++) { 
                if(str.charAt(i)-'0' > 0 && str.charAt(i)-'0' <= 9) sb.append(str.charAt(i));
                else { 
                    if(tmp.isEmpty()) tmp.push(str.charAt(i));
                    else { 
                        if(tmp.peek() == '+' || tmp.peek() == '-') { 
                            if(str.charAt(i) == '*' || str.charAt(i) == '/' || str.charAt(i) == '(') { 
                                tmp.push(str.charAt(i));
                            } else if(str.charAt(i) == '+' || str.charAt(i) == '-') { 
                                while(true) {
                                    sb.append(tmp.peek()); 
                                    tmp.pop(); 
                                    if(tmp.isEmpty() || tmp.peek() == '(') break;
                                }
                                tmp.push(str.charAt(i)); 
                            } else { 
                                while(true) {
                                    sb.append(tmp.peek()); 
                                    tmp.pop(); 
                                    if(tmp.isEmpty() || tmp.peek() == '(') break;
                                }
                                if(!(tmp.isEmpty()) && tmp.peek() == '(') 
                                    tmp.pop();
                            }
                        } else if(tmp.peek() == '*' || tmp.peek() == '/') { 
                            if(str.charAt(i) == '*' || str.charAt(i) == '/') { 
                                while(true) {
                                    sb.append(tmp.peek());
                                    tmp.pop();
                                    if(tmp.isEmpty() || tmp.peek() != '*' || tmp.peek() != '/') break;
                                }
                                tmp.push(str.charAt(i)); 
                            } else if(str.charAt(i) == '+' || str.charAt(i) == '-') { 
                                while(true) {
                                    if(tmp.isEmpty() || tmp.peek() == '(') break;
                                    sb.append(tmp.peek()); 
                                    tmp.pop();
                                }
                                tmp.push(str.charAt(i)); 
                            } else if(str.charAt(i) == '(') { 
                                tmp.push(str.charAt(i));
                            } else { 
                                while(true) {
                                    sb.append(tmp.peek());
                                    tmp.pop();
                                    if(tmp.isEmpty() || tmp.peek() == '(') break;
                                }
                                if(!(tmp.isEmpty()) && tmp.peek() == '(') 
                                    tmp.pop();
                                 
                            }
                        } else if(tmp.peek() == '('){
                            tmp.push(str.charAt(i));
                        }
                    }
                }
            }
             
            String tmpStr = sb.toString();
            Stack<Integer> tmpCalc = new Stack<>();
            int a, b;
            for(int i = 0; i < tmpStr.length(); i++) {
                if(tmpStr.charAt(i)-'0' > 0 && tmpStr.charAt(i)-'0' <= 9) { 
                    tmpCalc.push(tmpStr.charAt(i) - '0'); 
                } else { 
                    a = tmpCalc.peek();
                    tmpCalc.pop();
                    b = tmpCalc.peek();
                    tmpCalc.pop();
                    switch (tmpStr.charAt(i)) {
                    case '+':
                        tmpCalc.push(b+a);
                        break;
                    case '-':
                        tmpCalc.push(b-a);
                        break;
                    case '*':
                        tmpCalc.push(b*a);
                        break;
                    case '/':
                        tmpCalc.push(b/a);
                        break;
                    }
                }
            }
            System.out.println("#" + tc + " "+ tmpCalc.pop());
        }
	}
}
