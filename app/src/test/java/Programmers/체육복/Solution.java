package Programmers.체육복;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Solution {

    public int 나의_풀이(int students, int[] lost, int[] reserve) {
        // 체육복을 잃어버렸지만 여분을 가지고 있는 사람 체크
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        // 순서 정렬
        lost = Arrays.stream(lost).filter(i -> i > 0).sorted().toArray();
        reserve = Arrays.stream(reserve).filter(i -> i > 0).sorted().toArray();

        // 체육복을 잃어버린 사람 체크
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        lost = Arrays.stream(lost).filter(i -> i > 0).toArray();
        return students - lost.length;
    }

    public int 다른_사람의_풀이(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) {
            people[l - 1]--;
        }

        for (int r : reserve) {
            people[r - 1]++;
        }

        for (int i = 0; i < people.length; i++) {
            if (people[i] == -1) {
                if (i - 1 >= 0 && people[i - 1] == 1) {
                    people[i]++;
                    people[i - 1]--;
                } else if (i + 1 < people.length && people[i + 1] == 1) {
                    people[i]++;
                    people[i + 1]--;
                } else {
                    answer--;
                }
            }
        }
        return answer;
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    public void solution(int students, int[] lost, int[] reserve, int result) {
        int answer = 나의_풀이(students, lost, reserve);

        assertEquals(answer, result);
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    public void solution2(int students, int[] lost, int[] reserve, int result) {
        int answer = 다른_사람의_풀이(students, lost, reserve);

        assertEquals(answer, result);
    }

    private static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments(5, new int[]{2, 4}, new int[]{1, 3, 5}, 5),
                Arguments.arguments(5, new int[]{2, 4}, new int[]{3, 1}, 5),
                Arguments.arguments(5, new int[]{2, 4}, new int[]{3}, 4),
                Arguments.arguments(3, new int[]{3}, new int[]{1}, 2),
                Arguments.arguments(5, new int[]{1, 2, 4}, new int[]{2, 3, 4, 5}, 4),
                Arguments.arguments(5, new int[]{1, 2, 4}, new int[]{4, 5, 2}, 4),
                Arguments.arguments(3, new int[]{2, 3}, new int[]{3}, 2)
        );
    }
}
