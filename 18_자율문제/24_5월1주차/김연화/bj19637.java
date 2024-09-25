import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        String[][] title=new String[N][2];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            title[i][0]=st.nextToken();
            title[i][1]=st.nextToken();
        }

        for(int i=0;i<M;i++){
            int num=Integer.parseInt(br.readLine());

            int left=0;
            int right=N-1;
            int mid=(left+right)/2;
            while(left<=right){
                mid=(left+right)/2;

                int titleInt=Integer.parseInt(title[mid][1]);
                if(titleInt<num){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }

            sb.append(title[left][0]+"\n");
        }

        System.out.print(sb);
    }
}
