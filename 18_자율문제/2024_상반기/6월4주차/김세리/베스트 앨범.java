import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르별 총 재생 횟수를 저장하는 맵
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        // 장르별 노래 리스트를 저장하는 맵
        HashMap<String, ArrayList<int[]>> genreMusicList = new HashMap<>();

        int n = genres.length;
        
        // 장르별 재생 횟수와 노래 리스트를 초기화
        for (int i = 0; i < n; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);

            // 노래 정보 배열 [재생 횟수, 인덱스]
            int[] songInfo = {plays[i], i};
            
            // 장르별로 노래 리스트를 저장
            genreMusicList.putIfAbsent(genres[i], new ArrayList<>());
            genreMusicList.get(genres[i]).add(songInfo);
        }

        // 장르별 총 재생 횟수를 기준으로 장르를 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        // 결과를 저장할 리스트
        List<Integer> result = new ArrayList<>();

        // 각 장르별로 재생 횟수가 많은 순서대로 정렬 후 최대 2개의 노래를 결과에 추가
        for (String genre : sortedGenres) {
            List<int[]> songs = genreMusicList.get(genre);
            songs.sort((a, b) -> b[0] - a[0]); // 재생 횟수 내림차순 정렬

            for (int i = 0; i < songs.size() && i < 2; i++) {
                result.add(songs.get(i)[1]);
            }
        }

        // 결과를 배열로 변환
        int[] answer = result.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}
