modification = input()
sign_arr = []
num_arr = []
temp = ""
for i in modification:
    if i == '+' or i == '-':
        num_arr.append(int(temp))
        sign_arr.append(i)
        temp = ""
    else:
        temp += i
num_arr.append(int(temp))

flag = False
for idx, val in enumerate(sign_arr):
    if flag == False and val == '-':
        flag = True
    elif flag == True and val == '+':
        sign_arr[idx] = '-'
    else:
        pass

ans = num_arr[0]
for idx, val in enumerate(sign_arr):
    if val == '+':
        ans += num_arr[idx + 1]
    else:
        ans -= num_arr[idx + 1]
print(ans)