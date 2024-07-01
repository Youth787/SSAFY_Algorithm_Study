// 코드 외우면 좋을듯 

import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 플레이리스트별 재생횟수
        HashMap<String, Integer> genrecnt = new HashMap<>();
        // 장르별 재생횟수
        HashMap<String, ArrayList<int[]>> musiclist = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            genrecnt.put(genres[i], genrecnt.getOrDefault(genres[i],0)+plays[i]);
            
            int[] song = {plays[i], i};
            
            musiclist.putIfAbsent(genres[i], new ArrayList<>());
            musiclist.get(genres[i]).add(song);
        }
        List<String> sortmusic = new ArrayList<>(genrecnt.keySet());
        sortmusic.sort((a,b)-> genrecnt.get(b)-genrecnt.get(a)); // 내림차순 
        
        List<Integer> result = new ArrayList<>();
        
        for(String genre : sortmusic){
            List<int[]> songs = musiclist.get(genre);
            songs.sort((a,b)-> b[0]-a[0]);
            
            for(int i=0; i<songs.size()&& i<2; i++){
                result.add(songs.get(i)[1]);
            }
        }
        
        int[] answer = result.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
