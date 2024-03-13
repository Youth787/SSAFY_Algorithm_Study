import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
 
    private static ArrayList<Integer> primes;
    public static boolean[] primeNumcheck;
    private static int n;
    private static int cnt;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // 소수 구하기
 
        primeNumcheck = new boolean[n+1];
        primes = new ArrayList<Integer>();
 
        primeNumcheck[0]=primeNumcheck[1]=true;
        for(int i =2; i*i<=n; i++){
            if(!primeNumcheck[i]){
                for (int j = i*i; j <=n ; j += i) {
                    primeNumcheck[j]=true;
                }
            }
        }
        for (int i = 1; i <=n ; i++) {
            if(!primeNumcheck[i]){
                primes.add(i);
            }
        }
 
 
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        while (true){
            if(sum >= n){
                sum -= primes.get(start++);
            }else if(end == primes.size()){
                break;
            }else {
                sum += primes.get(end++);
            }
            if(n==sum){
                count++;
            }
        }
 
        System.out.println(count);
 
 
 
 
    }
}
