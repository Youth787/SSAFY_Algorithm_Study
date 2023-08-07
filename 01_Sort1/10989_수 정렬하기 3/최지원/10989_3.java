//시간초과 고려x (Scanner)
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        //입력될 숫자 개수
        int n = sc.nextInt();
        int [] arr = new int[n];
        
        //값 리스트에 저장
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        //값 비교해서 위치 이동
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i != j && arr[i]<arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        
        //한 줄씩 출력
        for (int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }
    }
}
