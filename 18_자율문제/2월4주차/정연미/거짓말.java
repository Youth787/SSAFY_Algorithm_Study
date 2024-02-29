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
        int ans = M;
        List<Integer>[] party = new ArrayList[M];
        Queue<Integer> truth = new LinkedList<>();
        boolean[] partyCheck = new boolean[M];
        boolean[] peopleCheck = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        int knowp = Integer.parseInt(st.nextToken());
        for(int i=0; i<knowp; i++){
            int person = Integer.parseInt(st.nextToken());
            truth.add(person);
            peopleCheck[person] =true;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            party[i] = new ArrayList<>();
            for(int j=0; j<num; j++){
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }// 입력받기 완료

        while(!truth.isEmpty()){
            int now = truth.poll();
            for(int i=0; i<M; i++){
                if(partyCheck[i]) continue;
                if(!party[i].contains(now)) continue;
                for(int j=0; j<party[i].size(); j++){
                    if(peopleCheck[party[i].get(j)]) continue;
                    peopleCheck[party[i].get(j)] = true;
                    truth.add(party[i].get(j));
                }
                partyCheck[i] = true;
                ans--;
            }
        }
        System.out.println(ans);
    }
}
