package Programmers.K번째수;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// https://programmers.co.kr/learn/courses/30/lessons/42748
// 다시 푼 날짜 : 220415
public class Solution {

    public int[] 나의_풀이(int[] array, int[][] commands) {
        int[] result = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] newArr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(newArr);
            result[i] = newArr[commands[i][2] - 1];
        }

        return result;
    }

    @Test
    public void solution() {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = 나의_풀이(array, commands);
        int[] result = {5, 6, 3};

        assertArrayEquals(answer, result);
    }
}
