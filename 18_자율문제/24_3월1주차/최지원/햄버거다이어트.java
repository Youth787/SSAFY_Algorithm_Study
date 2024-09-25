import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
 
/*
 * [문제] 햄버거 재료 점수와 재료 칼로리가 주어졌을 때, 좋아하면서도 정해진 칼로리 이하를 만족하는 조합 만들어서 점수 출력
 * [조건] 여러 재료 조합 시 선호도는 재료 맛의 점수 합, 재료 한번씩만 사용 가능.
 * [입력] t, n(재료 수), l(칼로리 제한), n개의 줄에 맛점수 칼로리
 */
public class Solution {
    static int n; //재료 수
    static int l;//칼로리 제한
    static int sumT; //지금 재료 조합의 맛 점수 합
    static int sumK; //지금 재료 조합의 총 칼로리
    static int max; //조합들 중 맛 점수 최상     
    static int[][] info; //[n][0]에는 점수 [n][1]에는 칼로리 저장
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for (int tc = 1; tc<=t; tc++) {
            n = sc.nextInt(); //재료 수
            l = sc.nextInt();//칼로리 제한
            info = new int [n][2];
             
            for (int i = 0; i<n; i++) {
                info[i][0] = sc.nextInt();
                info[i][1] = sc.nextInt();
            }
             
            max=0; //조합들 중 맛 점수 최상
             
            comb(0,0,0);
 
            System.out.println("#" + tc + " " + max);     
        } //tc
    } //main

    public static void comb (int idx, int sumT, int sumK) { 
        //기저파트
        if (idx == n) {
            if (sumK <= l ) {
                if( max < sumT) {
                    max = sumT;
                }
            }
            return;
        }
         
        //재귀파트
        comb(idx+1,sumT+info[idx][0], sumK+info[idx][1]); //뽑았다 
        comb(idx+1,sumT, sumK); //안 뽑았다
        return;     
    } //comb
} //class
