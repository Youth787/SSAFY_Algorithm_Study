//아직 하는 중
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException   {
    	
        //InputStreamReader를 이용해 보조스트림 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int [] arr = new int[N];
        
        String [] a = new String[N];
        for (int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
