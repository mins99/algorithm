## 참고

+ [해시를 이용한 방법](https://coding-grandpa.tistory.com/entry/프로그래머스-완주하지-못한-선수-해시-Lv-1)


+ 해결책 1 : Sorting 한 뒤에 Loop을 통해 1:1 비교
+ 해결책 2 : 해시를 사용하는 방법
  + hashmap에 넣을때는 participantList.put(person, participantList.getOrDefault(person, 0) + 1); 를 사용
  + hashmap에서 뺄 때는 participantList.put(person, participantList.get(person) - 1); 를 사용함
  + value가 1인 값을 return
