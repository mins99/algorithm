package Programmers.없는_숫자_더하기;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// https://programmers.co.kr/learn/courses/30/lessons/86051
// 푼 날짜 : 220421
public class Solution {

    public int 나의_풀이(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        return 45-sum;
    }

    public int 다른_사람의_풀이_for(int[] numbers) {
        int sum = 45;
        for (int number : numbers) {
            sum -= number;
        }
        return sum;
    }

    public int 다른_사람의_풀이_stream(int[] numbers) {
        return IntStream.range(0, 10).filter(i -> Arrays.stream(numbers).noneMatch(num -> i == num)).sum();
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    @DisplayName("나의 풀이")
    public void solution(int[] numbers, int result) {
        int answer = 나의_풀이(numbers);

        assertEquals(result, answer);
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    @DisplayName("다른_사람의_풀이_stream")
    public void solution2(int[] numbers, int result) {
        int answer = 다른_사람의_풀이_stream(numbers);

        assertEquals(result, answer);
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    @DisplayName("다른_사람의_풀이_for")
    public void solution3(int[] numbers, int result) {
        int answer = 다른_사람의_풀이_for(numbers);

        assertEquals(result, answer);
    }

    private static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{1,2,3,4,6,7,8,0}, 14),
                Arguments.arguments(new int[]{5,8,4,0,6,7,9}, 6)
        );
    }
}
