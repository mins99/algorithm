package Programmers.올바른_괄호;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// https://programmers.co.kr/learn/courses/30/lessons/12909
// 푼 날짜 : 220426
public class Solution {

    private boolean 나의_풀이_charAt(String str) {
        int pivot = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                pivot++;
            } else if (str.charAt(i) == ')') {
                pivot--;
            }

            if (pivot < 0) {
                return false;
            }
        }

        if (pivot != 0) {
            return false;
        }

        return true;
    }

    private boolean 나의_풀이_split(String str) {
        String[] strings = str.split("");
        int pivot = 0;

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("(")) {
                pivot++;
            } else if (strings[i].equals(")")) {
                pivot--;
            }

            if (pivot < 0) {
                return false;
            }
        }

        if (pivot != 0) {
            return false;
        }

        return true;
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    public void solution(String str, boolean result) {
        // given & when
        long start = System.currentTimeMillis();
        boolean answer = 나의_풀이_charAt(str);
        long end = System.currentTimeMillis();
        System.out.println("charAt 수행시간: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        boolean answer2 = 나의_풀이_split(str);
        end = System.currentTimeMillis();
        System.out.println("split 수행시간: " + (end - start) + " ms");

        // then
        assertEquals(answer, result);
    }

    private static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments("()()", true),
                Arguments.arguments("(())()", true),
                Arguments.arguments(")()(", false),
                Arguments.arguments("(()(", false),
                Arguments.arguments("()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()", true)
        );
    }
}
