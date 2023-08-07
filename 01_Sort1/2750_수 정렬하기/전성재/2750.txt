import java.util.Arrays;
import java.util.Scanner;

public class Main {

public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    
    // 배열에 입력받는 수 넣기
    for(int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
    }
    Arrays.sort(arr);
    
    for(int i = 0; i < N; i++) {
        System.out.println(arr[i]);
    }
    
    
}
}
