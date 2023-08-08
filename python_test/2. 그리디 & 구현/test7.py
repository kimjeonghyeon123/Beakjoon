# str = input()
#
# arr = []
# count = 0
# # 영어면 앞으로 보내고
# # 영어가 아니면 더함
# for i in range(len(str)):
#     if ord('A') <= ord(str[i]) <= ord('Z'):
#        arr.append(str[i])
#     else:
#         count += int(str[i])
#
# arr = sorted(arr)
#
# for i in arr:
#     print(i, end='')
#
# print(count)

data = input()
result = []
value = 0

for x in data:
    # 알파벳인지 확인
    if x.isalpha():
        result.append(x)
    else:
        value += int(x)
# 정렬
result.sort()

if value != 0:
    result.append(str(value))

# 리스트를 문자열로 변환하여 출력
print(''.join(result))