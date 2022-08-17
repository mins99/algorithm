package Programmers.크레인_인형뽑기_게임;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class Solution {

    public int 나의_풀이(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            int idx = move - 1;
            for (int j = 0; j < board.length; j++) {
                int value = board[j][idx];
                if (value != 0) {
                    if (stack.empty() || stack.peek() != value) {
                        stack.push(value);
                    } else {
                        stack.pop();
                        answer += 2;
                    }
                    board[j][idx] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    @Test
    public void solution() {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int result = 4;

        int answer = 나의_풀이(board, moves);

        assertEquals(answer, result);
    }
}
