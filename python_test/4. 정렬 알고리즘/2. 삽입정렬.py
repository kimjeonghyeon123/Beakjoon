# 삽입정렬
# 더 효율적임
# 앞의 수는 정렬되있다고 가정하고 정렬함
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(1, len(array)):
    for j in range(i, 0, -1):
        if array[j] < array[j - 1]: # 왼쪽으로 한칸씩 보냄
            array[j], array[j - 1] = array[j - 1], array[j]
        else:
            break

print(array)