package p1152_단어의개수;

/*
 * 영어 대소문자와 공백으로 이루어진 문자열에 있는 단어 개수.
 * 중복해서 카운트.
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        StringTokenizer st = new StringTokenizer(string," ");
        System.out.println(st.countTokens());
    } //main
} //class
