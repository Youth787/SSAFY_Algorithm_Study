import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] point;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        point=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            point[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(point);

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            // 이분탐색 -> 가능한 위치 인덱스 가져오기
            int start_idx=binarySearch(start,0);
            int end_idx=binarySearch(end,1);

            System.out.println(end_idx-start_idx);
        }
    }

    private static int binarySearch(int start, int check) {
        int left=0;
        int right= point.length-1;

        if(check==0){
            while(left<=right){
                int mid=(left+right)/2;
                if (point[mid] < start) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }

            return left;
        }
        else{
            while(left<=right){
                int mid=(left+right)/2;
                if(point[mid]>start){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }

            return right+1;
        }

    }
}
