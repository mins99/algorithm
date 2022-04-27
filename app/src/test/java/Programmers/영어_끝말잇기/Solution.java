package Programmers.영어_끝말잇기;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/12981
// 푼 날짜 : 220413
/*
끝말잇기의 규칙은 아래와 같다.
1. 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
2. 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
3. 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
4. 이전에 등장했던 단어는 사용할 수 없습니다.
5. 한 글자인 단어는 인정되지 않습니다.
*/
public class Solution {
    public int[] 나의_풀이(int n, String[] words) {
        int[] answer = {0, 0};
        int turn = 1;

        List<String> wordList = new ArrayList<String>();
        String str = words[0].substring(words[0].length() - 1);
        wordList.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            // 1. 앞사람이 말한 단어의 마지막 문자로 시작하는 단어인지
            if (!str.equals(words[i].substring(0, 1))) {
                answer[0] = i % n + 1;
                break;
            }
            // 2. 이전에 등장하지 않은 단어인지
            if (wordList.contains(words[i])) {
                answer[0] = i % n + 1;
                break;
            }

            str = words[i].substring(words[i].length() - 1);
            wordList.add(words[i]);
        }

        if (answer[0] != 0) {
            answer[1] = wordList.size() / n + 1;
        }

        return answer;
    }

    @Test
    public void 이미_등장한_단어인_경우() {
        int[] 나의_풀이 = 나의_풀이(3,
                new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        Assertions.assertArrayEquals(new int[]{3, 3}, 나의_풀이);
    }

    @Test
    public void 앞사람이_말한_단어의_마지막_문자가_아닌_경우() {
        int[] 나의_풀이 = 나의_풀이(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});
        Assertions.assertArrayEquals(new int[]{1, 3}, 나의_풀이);
    }

    @Test
    public void 정상적으로_끝난_끝말잇기인_경우() {
        int[] 나의_풀이 = 나의_풀이(5,
                new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
                        "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});
        Assertions.assertArrayEquals(new int[]{0, 0}, 나의_풀이);
    }
}
