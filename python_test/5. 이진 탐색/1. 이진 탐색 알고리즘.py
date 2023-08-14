'''
- 순차 탐색
    - 리스트 안에 있는 특정한 데이터를 찾기 위해 앞에서부터
      데이터를 하나씩 확인하는 방법
- 이진 탐색
    - 정렬되어 있는 리스트에서 탐색 범위를 절반씩 좁혀가며 탐색
    - 시작점, 끝점, 중간점을 이용해 탐색 범위 설정
    - O(logN)

- step1
    - 시작점 : 0, 끝점 : 9, 중간점 : 4 (소수점 이하 제거)
    - 찾고자하는 값이 중간점의 값보다 작으면 끝점을 중간점의 왼쪽으로
      옮김, 새로운 중간점을 찾음
'''

def binary_search(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2

    if array[mid] == target:
        return mid
    elif array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    else:
        return binary_search(array, target, mid + 1, end)

n, target = map(int, input().split())
array = list(map(int, input().split()))

result = binary_search(array, target, 0, n - 1)
if result == None:
    print('원소가 존재하지 않습니다.')
else:
    print(result)

# result는 찾은 값의 인덱스를 반환함