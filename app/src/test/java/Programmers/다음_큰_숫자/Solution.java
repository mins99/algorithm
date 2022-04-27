package Programmers.다음_큰_숫자;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

// https://programmers.co.kr/learn/courses/30/lessons/12911
// 푼 날짜 : 220412
public class Solution {

    public int 나의_풀이(int n) {
        int inputBitCnt = Integer.bitCount(n);
        int answer = n + 1;

        while (true) {
            if (Integer.bitCount(answer) == inputBitCnt) {
                break;
            }
            answer++;
        }

        return answer;
    }

    @ParameterizedTest
    @CsvSource(value = {"78:83", "15:23"}, delimiter = ':')
    public void solution(int number, int result) {
        // given
        int 나의_풀이 = 나의_풀이(number);

        // then
        assertEquals(나의_풀이, result);
    }

}
