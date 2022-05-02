package Programmers.전화번호_목록;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// https://programmers.co.kr/learn/courses/30/lessons/42577
// 푼 날짜 : 220429
public class Solution {
    public boolean 나의_풀이(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }

    public boolean 다른_사람의_풀이(String[] phone_book) {
        HashSet<String> phoneList = new HashSet<>(Arrays.asList(phone_book));

        for(String str : phone_book){
            for(int i = 1; i < str.length(); i++){
                if(phoneList.contains(str.substring(0, i))){
                    return false;
                }
            }
        }

        return true;
    }


    @ParameterizedTest
    @MethodSource("parameterProvider")
    public void solution(String[] phone_book, boolean result) {
        boolean answer = 나의_풀이(phone_book);
        boolean answer2 = 다른_사람의_풀이(phone_book);

        assertEquals(answer, result);
        assertEquals(answer2, result);
    }

    private static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments(new String[]{"119", "97674223", "1195524421"}, false),
                Arguments.arguments(new String[]{"123","456","789"}, true),
                Arguments.arguments(new String[]{"12","123","1235","567","88"}, false)
        );
    }
}
