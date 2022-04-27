package Programmers.소수_만들기;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/12977
// 푼 날짜 : 220414
public class Solution {
    List<Integer> answer = new ArrayList<>();

    public int 나의_풀이(int[] n) {
        combination(n, new boolean[n.length], 0, 3);
        return answer.size();
    }

    public void combination(int[] n, boolean[] visited, int depth, int r) {
        if (r == 0) {
            int num = isPrime(n, visited);
            if (num != -1) {
                answer.add(num);
            }
            return;
        }
        if (depth == n.length) {
            return;
        } else {
            visited[depth] = true;
            combination(n, visited, depth + 1, r - 1);

            visited[depth] = false;
            combination(n, visited, depth + 1, r);
        }
    }

    public int isPrime(int[] n, boolean[] visited) {
        int checkNum = 0;

        for (int i = 0; i < n.length; i++) {
            if (visited[i] == true) {
                checkNum += n[i];
            }
        }

        boolean isPrime = true;
        for (int i = 2; i < checkNum; i++) {
            if (checkNum % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            return checkNum;
        } else {
            return -1;
        }
    }

    public int 다른사람의_풀이(int[] n) {
        int answer = 0;

        for (int i = 0; i < n.length; i++) {
            for (int j = i + 1; j < n.length; j++) {
                for (int k = j + 1; k < n.length; k++) {
                    int checkNum = n[i] + n[j] + n[k];
                    if (isPrime2(checkNum)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }


    public boolean isPrime2(int n) {
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

    public boolean isPrime3(int n) {
        boolean isPrime = true;

        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

    @Test
    public void solution() {
        int[] nums = {1, 2, 7, 6, 4};
        System.out.println("answer = " + 나의_풀이(nums));
    }
}
