package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

// 내림차순(사전순)으로 정렬
// Collections.sort(member, Collections.reverseOrder());

// HashMap<String, List<String>> group = new HashMap<>();
// for(Map.Entry<String,List<String>> entry : group.entrySet()){
//      String key = entry.getKey();
//      List<String> value = entry.getValue();
//      if(value.contains(word)) {~~}
//  }

public class bj16165 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, List<String>> group = new HashMap<>();
        for(int i=0; i<N; i++){
            String input = br.readLine();
            int number = Integer.parseInt(br.readLine());
            List<String> member = new LinkedList<>();
            for(int j=0; j<number;j++) member.add(br.readLine());
            Collections.sort(member);
            group.put(input,member);
        }
        out : for(int i=0;i<M; i++){
            String word = br.readLine();
            int num = Integer.parseInt(br.readLine());
            if(num==1){
                for(Map.Entry<String,List<String>> entry : group.entrySet()){
                    String key = entry.getKey();
                    List<String> value = entry.getValue();

                    if(value.contains(word)){
                        System.out.println(key);
                        continue out;
                    }
                }
            }else if(num==0)
                for(String mem : group.get(word)) System.out.println(mem);
        }
    }
}

----------------------------------------------------------------------------------
