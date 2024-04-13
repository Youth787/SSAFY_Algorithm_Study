import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 맵 미리 생성
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);

        // 필터링된 데이터 구하기
        int extIdx = map.get(ext); // ext에 해당하는 인덱스 가져오기
        int sortIdx = map.get(sort_by); // sort_by에 해당하는 인덱스 가져오기

        List<int[]> filteredList = new ArrayList<>();
        for (int[] entry : data) {
            if (entry[extIdx] < val_ext) {
                filteredList.add(entry);
            }
        } // 기간 전이면 리스트에 넣기
        
        // 정렬
        Collections.sort(filteredList, Comparator.comparingInt(arr -> arr[sortIdx]));

        // 2차원 배열로 변환
        int[][] filteredData = new int[filteredList.size()][];
        for (int i = 0; i < filteredList.size(); i++) {
            filteredData[i] = filteredList.get(i);
        }

        return filteredData;
    }
}
