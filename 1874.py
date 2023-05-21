stack = []
li = []
res = []
n = int(input())
i = 1
import sys
for _ in range(n):
    li.append(int(input()))
li.reverse()
while li:
    if stack and stack[-1] == li[-1]:
        stack.pop()
        li.pop()
        res.append('-')
    else:
        stack.append(i)
        i += 1
        res.append('+')
    if i > n + 1:
        print("NO")
        sys.exit()
for x in res:
    print(x)