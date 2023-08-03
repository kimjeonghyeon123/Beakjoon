# 공포도가 X인 모험가는 X명 이상인 그룹에 참여
# 최대한 많은 그룹 나오게

# 공포도가 낮은 것과 높은 것을 묶어라
# ex) 123456
# (1 : 1), (2 : 6,5)

n = int(input())
data = list(map(int, input().split()))

data.sort()

result = 0 # 총 그룹의 수
count = 0 # 현재 그룹에 포함된 모험가의 수

for i in data:
    count += 1
    if count >= i:
        result += 1
        count = 0

print(result)
