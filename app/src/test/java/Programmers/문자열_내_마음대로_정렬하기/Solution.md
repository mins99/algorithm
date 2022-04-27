## 정렬하는 방법

### 1. Comparable

+ 객체 비교의 경우 `implements Comparable<클래스명>` 을 추가한 후 @Override 한 compareTo를 작성한다

```java
public class Player implements Comparable<Player> {
    // Fields, Getters, Setters 생략

    @Override
    public int compareTo(Player o) {
        return o.getScore() - getScore();
    }
}
```

+ 이후 `Collections.sort(players);` 를 호출하면 compareTo 조건에 따라 정렬된다

### 2. Comparator

+ String 배열의 경우 따로 객체가 없기 때문에 내부에 compareTo를 재정의할 수 없다
+ 이 경우 Comparator를 새로 구현한다

```java
Comparator<Player> comparator = new Comparator<Player>() {
    @Override
    public int compare(Player a, Player b) {
        return b.getScore() - a.getScore();
    }
};
```

+ 이후 `Collections.sort(players, comparator);` 와 같이 sort 호출시 두번째 매개변수에 해당 comparator를 전달한다
+ return 조건의 경우 if ~ else 를 통해 추가적인 조건을 명시 가능하다
    + 이번에 사용한 소스코드를 보면 특정 인덱스의 글자를 비교하고, 글자가 동일한 경우 문자열 자체를 비교하도록 구현했음
+ comparator 자체를 sort 부분에 넣는 것도 가능하다

### 3. 람다

+ comparator의 경우 람다식을 사용하면 더욱 간결하게 구현 가능하다
+ 단순 비교로 compare 메서드에서 return만 하는 경우 람다를 통해 다음과 같이 구현 가능하다

`Collections.sort(players, (a, b) -> b.getScore() - a.getScore());`

### 4. Stream

+ 기존 객체의 순서를 변경하지 않고, 새롭게 정렬된 객체를 생성하고자 할 때 사용한다

```java
List<Player> sortedPlayers = players.stream()
        .sorted((a, b) -> b.getScore() - a.getScore())
        .collect(Collectors.toList());
```

---

출처 : https://www.daleseo.com/java-comparable-comparator/