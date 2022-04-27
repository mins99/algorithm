package Programmers.하샤드_수;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


// https://programmers.co.kr/learn/courses/30/lessons/12947
// 푼 날짜 : 220411
public class Solution {

    boolean 나의_풀이(int x) {
        boolean answer = true;
        int sum = 0;
        int originNum = x;

        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        x += sum;

        if (originNum % sum != 0) {
            answer = false;
        }

        return answer;
    }


    boolean 다른_사람의_풀이(int x) {
        boolean answer = true;
        String[] nums = String.valueOf(x).split("");

        int sum = 0;
        for (String str : nums) {
            sum += Integer.parseInt(str);
        }

        if (x % sum != 0) {
            answer = false;
        }

        return answer;
    }

    @Test
    public void solution() {
        // 10은 하샤드 수
        assertTrue(나의_풀이(10));
        assertTrue(다른_사람의_풀이(10));

        // 12는 하샤드 수
        assertTrue(나의_풀이(12));
        assertTrue(다른_사람의_풀이(12));

        // 11은 하샤드 수가 아님
        assertFalse(나의_풀이(11));
        assertFalse(다른_사람의_풀이(11));

        // 13은 하샤드 수가 아님
        assertFalse(나의_풀이(13));
        assertFalse(다른_사람의_풀이(13));
    }

    @ParameterizedTest
    @CsvSource(value = {"10:true", "12:true", "11:false", "13:false"}, delimiter = ':')
    public void solution1(int number, boolean result) {
        // given
        boolean 나의_풀이 = 나의_풀이(number);
        boolean 다른_사람의_풀이 = 다른_사람의_풀이(number);

        // then
        assertAll(
                () -> assertEquals(나의_풀이, 다른_사람의_풀이),
                () -> assertEquals(나의_풀이, result),
                () -> assertEquals(다른_사람의_풀이, result)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 12})
    public void 하샤드_수인_경우_결과는_참이다(int number) {
        // given
        boolean 나의_풀이 = 나의_풀이(number);

        // then
        assertTrue(나의_풀이);
    }

    @Test
    public void 하샤드_수가_아닌_경우_결과는_거짓이다() {
        // given
        boolean 나의_풀이 = 나의_풀이(11);

        // then
        assertFalse(나의_풀이);
    }

    @Test
    public void 나의_풀이_와_다른_사람의_풀이가_일치한다() {
        // given
        boolean 나의_풀이 = 나의_풀이(10);
        boolean 다른_사람의_풀이 = 다른_사람의_풀이(10);

        // then
        assertEquals(나의_풀이, 다른_사람의_풀이);
    }

    @Test
    public void 나의_풀이_와_다른_사람의_정답이_다를_경우_실패한다() {
        // given11
        boolean 나의_풀이 = 나의_풀이(10);
        boolean 다른_사람의_풀이 = 다른_사람의_풀이(11);

        // then
        assertNotEquals(나의_풀이, 다른_사람의_풀이);
    }
}
