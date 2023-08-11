# O(N + K)
# 0, 99999 두 개만 있는 경우 비효율적임
# count 배열을 만들기 때문
# 동일한 값을 가지는 데이터가 여러 개일 때 효과적
array = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]

count = [0] * (max(array) + 1)

for i in range(len(array)):
    count[array[i]] += 1

for i in range(len(count)):
    for j in range(count[i]):
        print(i, end=' ')