# 동북서남
# dx = [0, -1, 0, 1]
# dy = [1, 0, -1, 0]
#
# x, y = 2, 2
#
# for i in range(4):
#     nx = x + dx[i]
#     ny = y + dy[i]
#     print(nx, ny)

# N = int(input())
# data = input().split()
#
# x, y = 1, 1
#
# for i in data:
#     if i == 'L':
#         if y == 0:
#             continue
#         else:
#             y -= 1
#     elif i == 'R':
#         if y == N:
#             continue
#         else:
#             y += 1
#     elif i == 'U':
#         if x == 1:
#             continue
#         else:
#             x -= 1
#     elif i == 'D':
#         if x == N:
#             continue
#         else:
#             x += 1
#
# print(x, y)

N = int(input())
x, y = 1, 1
plans = input().split()

# L R U D
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
move_types = ['L', 'R', 'U', 'D']

for plan in plans:
    for i in range(len(move_types)):
        if plan == move_types[i]:
            nx = x + dx[i]
            ny = y + dy[i]
    if nx < 1 or ny < 1 or nx > N or ny > N:
        continue
    x, y = nx, ny

print(x, y)