import java.util.*;

//프로그래머스 pcce기출 10번 데이터분석
class Solution {
    static int number;
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<Integer> list = new ArrayList<>();
        number = -1;
        findNum(ext);
        for (int i = 0; i < data.length; i++) {
            if (data[i][number] < val_ext) list.add(i);
        }
        findNum(sort_by);
        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = data[list.get(i)];
        }
        Arrays.sort(answer, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[number] - o2[number];
            }
        });
        return answer;
    }
    static void findNum(String str) {
        switch(str) {
            case "code":
                number = 0;
                break;
            case "date":
                number = 1;
                break;
            case "maximum":
                number = 2;
                break;
            case "remain":
                number = 3;
                break;
        }
    }
}


//다른사람풀이
// import java.util.*;

// class Solution {
//     public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

//         String[] arr = {"code","date","maximum","remain"};
//         List<String> columnList = Arrays.asList(arr);
//         int extIdx = columnList.indexOf(ext);
//         int sortIdx = columnList.indexOf(sort_by);
//         int[][] answer = Arrays.stream(data).filter(o1 -> o1[extIdx] < val_ext)
//             .sorted((o1 ,o2) -> o1[sortIdx]-o2[sortIdx]).toArray(int[][]::new);

//         return answer;
//     }
// }
