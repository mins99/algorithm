## 위장 - 경우의 수 계산
1) 각 종류 별로 하나씩 입은 경우의 수는 해당 종류의 옷을 입지 않은 경우가 있기 때문에 1을 더한 뒤 각 종류별로 곱한 것입니다. `answer *= (value + 1);`
2) 최종적으로 아무것도 입지 않은 경우는 없어야 하기 때문에 하나도 입지 않은 케이스를 빼줍니다. `answer--;`