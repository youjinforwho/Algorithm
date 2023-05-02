K = int(input())
stack = []
for i in range(K):
    n = int(input())
    if stack:
        if n == 0:
            stack.pop()
        else:
            stack.append(n)
    else:
        stack.append(n)
res = 0
for i in range(len(stack)):
    res += stack[i]
print(res)