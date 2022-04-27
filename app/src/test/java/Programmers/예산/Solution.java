package Programmers.예산;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// https://programmers.co.kr/learn/courses/30/lessons/12982
// 푼 날짜 : 220419
public class Solution {
    int 나의_풀이(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for (int dept : d) {
            if (budget - dept >= 0) {
                answer++;
            }
            budget -= dept;
        }
        return answer;
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    void solution(int[] dept, int budget, int result) {
        // given & when
        int answer = 나의_풀이(dept, budget);

        // then
        assertEquals(result, answer);
    }

    private static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{2, 2, 3, 3}, 10, 4),
                Arguments.arguments(new int[]{1, 3, 2, 5, 4}, 9, 3)
        );
    }
}
