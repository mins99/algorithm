package Programmers.내적;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// https://programmers.co.kr/learn/courses/30/lessons/70128
// 푼 날짜 : 220418
public class Solution {

    public int 나의_풀이(int[] a, int[] b) {
        int result = 0;

        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }

        return result;
    }

    public int 다른_사람의_풀이(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    @DisplayName("나의_풀이")
    public void solution(int[] a, int[] b, int answer) {
        int input = 나의_풀이(a, b);

        assertEquals(input, answer);
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    @DisplayName("다른_사람의_풀이")
    public void solution2(int[] a, int[] b, int answer) {
        int input = 다른_사람의_풀이(a, b);

        assertEquals(input, answer);
    }

    private static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2}, 3),
                Arguments.arguments(new int[]{-1, 0, 1}, new int[]{1, 0, -1}, -2)
        );
    }
}
