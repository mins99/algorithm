package Programmers.문자열_내_마음대로_정렬하기;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/12915
    // 푼 날짜 : 220416
    public String[] 나의_풀이_Comparator(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.charAt(n) > b.charAt(n)) {
                    return 1;
                } else if (a.charAt(n) == b.charAt(n)) {
                    return a.compareTo(b);
                } else {
                    return -1;
                }
            }
        });

        return strings;
    }

    @Test
    public void solution() {
        String[] input = {"sun", "bed", "car"};
        String[] input2 = {"abce", "abcd", "cdx"};

        String[] answer = 나의_풀이_Comparator(input, 1);
        String[] answer2 = 나의_풀이_Comparator(input2, 2);

        Assertions.assertArrayEquals(answer, new String[]{"car", "bed", "sun"});
        Assertions.assertArrayEquals(answer2, new String[]{"abcd", "abce", "cdx"});
    }
}
