# (위로 두번, 왼쪽), (위로 두번, 오른쪽),
# (아래로 두번, 왼쪽), (아래로 두번, 오른쪽),
# (위로 한번, 왼쪽 두번), (아래로 한번, 왼쪽 두번),
# dx = [-2, -2, 2, 2, -1, 1, -1, 1]
# dy = [-1, 1, -1, 1, -2, -2, 2, 2]
#
# input_data = input()
#
# x = int(input_data[1])
# y = int(ord(input_data[0])) - int(ord('a')) + 1
#
# count = 0
# for i in range(len(dx)):
#     nx = x + dx[i]
#     ny = y + dy[i]
#
#     if nx <= 0 or nx >= 8 or ny <= 0 or ny >= 8:
#         continue
#     else:
#         count += 1
#
# print(count)

input_data = input()

x = int(input_data[1])
y = int(ord(input_data[0])) - int(ord('a')) + 1

steps = [(-2, -1), (-2, 1), (2, -1), (2, 1), (-1, -2), (-1, 2), (1, -2), (1, 2)]

result = 0
for step in steps:
    next_x = x + step[0]
    next_y = y + step[1]

    if next_x >= 1 and next_x <= 8 and next_y >= 1 and next_y <= 8:
        result += 1

print(result)