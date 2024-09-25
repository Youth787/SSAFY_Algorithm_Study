import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            int num = Integer.parseInt(input[i]);

            if(isPrime(num)){
                arr.add(num);
            }
        }

        if(arr.isEmpty()){
            System.out.println(-1);
            return;
        }

        Collections.sort(arr);

        long lcm = -1;
        for (int i = 0; i < arr.size()-1; i++) {
            if(lcm == -1)
                lcm = lcm(arr.get(i), arr.get(i+1));
            else
                lcm = lcm(lcm, arr.get(i+1));
        }

        System.out.println(lcm);
    }

    public static long gcd(long num1, long num2){

        long a = Math.min(num1, num2);
        long b = Math.max(num1, num2);
        long temp = 0;
        while(true){
            temp = a;
            a = b%a;
            b = temp;
            if( a == 0)
                break;
        }
        return b;
    }

    public static long lcm(long num1, long num2){

        return num1*num2/gcd(num1, num2);
    }

    public static boolean isPrime(int num){

        if(num < 2)
            return false;

        int sqrt = (int)Math.sqrt(num);

        for (int i = 2; i <= sqrt; i++) {
            if(num % i == 0)
                return false;
        }

        return true;
    }
}
