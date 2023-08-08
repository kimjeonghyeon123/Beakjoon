data = input()

result = int(data[0])

for i in range(1, len(data)):
    num = int(data[i])

    # 0과 1을 제외 하고 곱하는 게 더 큼
    if num <= 1 or result <= 1:
        result += num
    else:
        result *= num

print(result)