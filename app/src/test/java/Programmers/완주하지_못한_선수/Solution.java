package Programmers.완주하지_못한_선수;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// https://programmers.co.kr/learn/courses/30/lessons/42576
// 푼 날짜 : 220427
public class Solution {

    public String 다른사람의_풀이(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> participantList = new HashMap<>();
        for (String person : participant) {
            participantList.put(person, participantList.getOrDefault(person, 0) + 1);
        }
        for (String person : completion) {
            participantList.put(person, participantList.get(person) - 1);
        }

        for (String key : participantList.keySet()) {
            if (participantList.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    public void solution(String[] participant, String[] completion, String result) {
        String answer = 다른사람의_풀이(participant, completion);

        assertEquals(answer, result);
    }

    private static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}, "leo"),
                Arguments.arguments(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                        new String[]{"josipa", "filipa", "marina", "nikola"}, "vinko"),
                Arguments.arguments(new String[]{"mislav", "stanko", "mislav", "ana"},
                        new String[]{"stanko", "ana", "mislav"}, "mislav")
        );
    }
}
