# 선택정렬
# O(n²)
# 가장 작은 수를 맨 앞으로 보냄
# 수행할 때마다 가장 앞의 수가 가장 작은 수가 됨
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    min_index = i
    for j in range(i + 1, len(array)):
        if array[min_index] > array[j]:
            min_index = j
    array[i], array[min_index] = array[min_index], array[i]

print(array)