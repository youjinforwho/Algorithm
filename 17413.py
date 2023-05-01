S = input()
stack = ""
res = []
flag = False
for i in S:
    if i == ' ' and flag == False:
        res.append(stack[::-1])
        res.append(' ')
        stack = ""
    elif i == '<':
        res.append(stack[::-1])
        stack = '<'
        flag = True
    elif i == '>':
        stack += '>'
        res.append(stack)
        stack = ""
        flag = False
    else:
        stack += i
if stack:
    res.append(stack[::-1])
res = "".join(res)
print(res)