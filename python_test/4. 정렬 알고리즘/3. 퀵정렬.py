# 퀵 정렬
# 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법
# 빠름
# 왼쪽에서는 피벗보다 큰 데이터, 오른쪽에서는 작은 데이터를 골라 바꿈
# 서로 엇갈릴 때 피벗과 작은 데이터의 위치 변경
# 분할 됨
# 피벗 값에 따라 O(NlogN), O(N²)

array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array, start, end):
    if start >= end:
        return
    pivot = start
    left = start + 1
    right = end
    while left <= right:
        while left <= end and array[left] <= array[pivot]:
            left += 1
        while right > start and array[right] >= array[pivot]:
            right -= 1
        if left > right:
            array[right], array[pivot] = array[pivot], array[right]
        else:
            array[left], array[right] = array[right], array[left]

    quick_sort(array, start, right-1)
    quick_sort(array, right+1, end)

quick_sort(array, 0, len(array)-1)
print(array)
