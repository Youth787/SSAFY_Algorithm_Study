import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 배열 A의 사이즈
        int M = sc.nextInt();  // 배열 B의 사이즈

        List<Integer> A = new ArrayList<>();
        for(int i  = 0; i< N; i++){
            int n = sc.nextInt();
            A.add(n);
        }

        List<Integer> B = new ArrayList<>();
        for(int i = 0; i < M; i++){
            int n = sc.nextInt();
            B.add(n);
        }

        //logic
        List<Integer> result = new ArrayList<>();

        int i = 0, j= 0; // 배열 A의 인덱스, 배열 B의 인덱스
        while(i < N && j < M){
            int a = A.get(i);
            int b = B.get(j);

            if(a<= b){
                result.add(a);
                i++;
            } else {
                result.add(b);
                j++;
            }
        }
        //인덱스가 남아있는 경우도 고려
        for(; i<N; i++){
            result.add(A.get(i));
        }
        for(; j<M; j++){
            result.add(B.get(j));
        }
        //output
        StringBuilder sb = new StringBuilder();
        for(int e : result){
            sb.append(e + " ");
        }
        System.out.println(sb.toString());


    }

}
