package Programmers.음양_더하기;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// https://programmers.co.kr/learn/courses/30/lessons/76501
// 푼 날짜 : 220420
public class Solution {

    public int 나의_풀이(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    public void solution(int[] absolutes, boolean[] signs, int result) {
        // given & when
        int answer = 나의_풀이(absolutes, signs);

        // then
        assertEquals(answer, result);
    }

    private static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{4, 7, 12}, new boolean[]{true, false, true}, 9),
                Arguments.arguments(new int[]{1, 2, 3}, new boolean[]{false, false, true}, 0)
        );
    }
}
