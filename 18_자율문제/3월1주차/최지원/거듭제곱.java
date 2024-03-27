/*
 n의 m 거듭제곱 구하기
*/
import java.util.Scanner;
import java.io.FileInputStream;
 
 
class Solution  {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = 10;
 
 
        for(int tc = 1; tc <= t; tc++)  {
            int tt = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
             
            System.out.println("#" + tc + " " + pow(n,m));
        } //tc
    } //main
     
    public static int pow(int c, int n) {
        //기저조건
        if (n == 1)
            return c;
         
        //재귀조건
        if (n % 2 == 0) {
            int tmp1 = pow(c, n/2);
            return tmp1 * tmp1;
        } else {
            int tmp2 = pow(c, (n-1)/2);
            return tmp2 * tmp2 * c;
        }
    }//pow
}//class
