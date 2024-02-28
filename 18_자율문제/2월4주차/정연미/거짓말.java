package ALGO_STUDY.Fev_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://excited-hyun.tistory.com/231

public class 거짓말1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 파티의 수

        st = new StringTokenizer(br.readLine());
        int knowp = Integer.parseInt(st.nextToken());
        Set<Integer> truth= new HashSet<>();
        for(int i=0; i<knowp; i++){
            truth.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer>[] party = new ArrayList[M];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            party[i] = new ArrayList<>();
            for(int j=0; j<num; j++){
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }// 입력받기 완료

        int cnt =0;
        out : for(int i=0; i<M; i++){
            for(int j=0; j<party[i].size(); j++){
                if(truth.contains(party[i].get(j))) {
                    continue out;
                }
            }
            for(int j=0; j<party[i].size(); j++) {
                truth.add(party[i].get(j));
            }
        }

        System.out.println(cnt);
    }
}
