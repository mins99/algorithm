package Programmers.위장;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// https://programmers.co.kr/learn/courses/30/lessons/42578
// 푼 날짜 : 220428
public class Solution {

    public int 나의_풀이(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesList = new HashMap<>();
        for (String[] clothe : clothes) {
            clothesList.put(clothe[1], clothesList.getOrDefault(clothe[1], 0) + 1);     // containsKey를 사용하는 방법도?
        }

        for (int value : clothesList.values()) {
            answer *= (value + 1);
        }

        answer--;

        return answer;
    }

    public int 다른_사람의_풀이(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1;
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    public void solution(String[][] clothes, int result) {
        int answer = 나의_풀이(clothes);
        int answer2 = 다른_사람의_풀이(clothes);

        Assertions.assertEquals(answer, result);
        Assertions.assertEquals(answer2, result);
    }

    private static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"},
                        {"green_turban", "headgear"}}, 5),
                Arguments.arguments(
                        new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}, 3)
        );
    }
}
