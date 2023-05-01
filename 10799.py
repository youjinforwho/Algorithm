exp = list(map(str, input()))
stack = []
flag = False
stick = res = 0
for i in range(len(exp)):
    if exp[i] == '(':
        if exp[i + 1] != ')':
            stick += 1
        else:
            flag = True
        stack.append('(')
    elif exp[i] == ')':
        if flag == True:
            res += stick
            flag = False
        else:
            stick -= 1
            res += 1
        stack.pop()
print(res)

