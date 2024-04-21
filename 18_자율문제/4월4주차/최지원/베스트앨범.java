import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
/*
 * 고유번호로 노래 구분. 장르 > 노래 > 고유번호 낮은 순
 * 장르별 재생 횟수 계산
 */
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap <String, ArrayList<int[]>> gen = new HashMap<>();
        HashMap <String, Integer> ply = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (!gen.containsKey(genre)) {
                gen.put(genre, new ArrayList<>());
                ply.put(genre, 0);
            }
            gen.get(genre).add(new int[]{i, play}); //고유번호i는 play번 재생
            ply.put(genre, ply.get(genre)+play); //장르 재생 수에 현재 play번 횟수 추가
        }
        ArrayList<Integer> answer = new ArrayList<>();
        Stream <Map.Entry<String, Integer>> sorted = ply.entrySet().stream().sorted((o1,o2)->Integer.compare(o2.getValue(), o1.getValue()));
        sorted.forEach(entry -> {
            Stream<int[]> sortedSongs = gen.get(entry.getKey()).stream().sorted((o1,o2)->Integer.compare(o2[1], o1[1])).limit(2);
            sortedSongs.forEach(song -> answer.add(song[0]));
        });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
