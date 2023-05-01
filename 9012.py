def check(seq):
    stack = []
    num = 0
    for i in seq:
        if i == '(':
            stack.append(i)
        else:
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                return 0
    if len(stack) == 0:
        return 1
    return 0

n = int(input())
s = []
for i in range(n):
    s.append(input())
    if check(s[i]) == 0:
        print("NO")
    else:
        print("YES")