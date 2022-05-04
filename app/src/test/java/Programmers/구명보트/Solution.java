package Programmers.구명보트;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Solution {

    // 문제에서는 구명보트에 타는 인원을 최대 2명으로 제한했다(인원제한이 없는 경우 이렇게..?)
    public int 나의_풀이(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 1;
        int newLimit = limit;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (newLimit >= people[right]) {
                newLimit -= people[right--];
            } else if (newLimit >= people[left]) {
                newLimit -= people[left++];
            } else {
                answer++;
                newLimit = limit;
            }
        }

        return answer;
    }

    // 구명보트에 타는 인원이 2명이라는 제한을 적용한 풀이
    public int 나의_풀이2(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left < right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
        }

        return people.length - left;
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    public void solution(int[] people, int limit, int result) {
        int answer = 나의_풀이2(people, limit);

        assertEquals(answer, result);
    }

    private static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{70, 50, 80, 50}, 100, 3),
                Arguments.arguments(new int[]{70, 80, 50}, 100, 3)
        );
    }
}
