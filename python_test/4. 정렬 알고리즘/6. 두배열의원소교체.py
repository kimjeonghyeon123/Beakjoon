# 배열 A, B
# 둘 다 N개의 원소로 구성
# 최대 K번의 바꿔치기 연산
# A, B 원소 교환하는 것
# A의 모든 원소의 합이 최대가 되도록 하는 것

# A의 가장 작은 원소와 B의 가장 큰 원소를 바꾸자
# A의 가장 작은 원소가 B의 가장 큰 원소보다 크거나 같을 경우 바꾸지 말자
# k번을 넘으면 안됨

N, K = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort()
B.sort(reverse=True)

for i in range(K):
    if A[i] < B[i]:
        A[i], B[i] = B[i], A[i]
    else:
        break

print(sum(A))
