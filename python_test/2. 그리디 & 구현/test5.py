# 00:00:00 ~ N:59:59
# 이 사이에 3이 들어간 시간의 수

h = int(input())

count = 0

for i in range(h + 1):
    for j in range(60):
        for k in range(60):
            if '3' in str(i) + str(j) + str(k):
                count += 1

print(count)