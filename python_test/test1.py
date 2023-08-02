N, K = map(int, input().split())

result = 0

while True:
    target = (N // K) * K # N과 가장 가까운 K의 배수
    result += (N - target) # 빼기 과정
    N = target

    if N < K:
        break
    result += 1
    N //= K

result += (N - 1)
print(result)


