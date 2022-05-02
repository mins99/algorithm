package Programmers.두_개_뽑아서_더하기;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.TreeSet;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// https://programmers.co.kr/learn/courses/30/lessons/68644
// 푼 날짜 : 220502
public class Solution {

    public int[] 나의_풀이(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        int i=0;
        for (Integer val : set) {
            answer[i++] = val;
        }

        return answer;
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    public void solution(int[] numbers, int[] result) {
        int[] answer = 나의_풀이(numbers);

        assertArrayEquals(answer, result);
    }

    private static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{2,1,3,4,1}, new int[]{2,3,4,5,6,7}),
                Arguments.arguments(new int[]{5,0,2,7}, new int[]{2,5,7,9,12})
        );
    }
}
