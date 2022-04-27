package Programmers.피보나치_수;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

// https://programmers.co.kr/learn/courses/30/lessons/12945
// 푼 날짜 : 220422
public class Solution {

    public int 나의_풀이_재귀함수(int n) {
        int number = 1234567;
        int answer = fibonacci(n) % number;

        return answer;
    }

    public int fibonacci(int n) {
        if(n <= 1) {
            return n;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

    public int 나의_풀이_배열(int n) {
        int[] arr = new int[n+1];

        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n] % 1234567;
    }

    @ParameterizedTest
    @CsvSource(value = {"3:2", "2:1", "5:5"}, delimiter = ':')
    public void solution(int n, int result) {
        int answer = 나의_풀이_재귀함수(n);
        int answer2 = 나의_풀이_배열(n);

        Assertions.assertEquals(answer, result);
        Assertions.assertEquals(answer2, result);
    }
}
