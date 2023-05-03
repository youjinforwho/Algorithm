n = int(input())
exp = input()
li = []
for i in range(n):
    li.append(int(input()))
res = ''
stack = []
for i in exp:
    if i == '*':
        stack[-2] = stack[-2] * stack[-1]
        stack.pop()
    elif i == '/':
        stack[-2] = stack[-2] / stack[-1]
        stack.pop()
    elif i == '+':
        stack[-2] = stack[-2] + stack[-1]
        stack.pop()
    elif i == '-':
        stack[-2] = stack[-2] - stack[-1]
        stack.pop()
    else:
        stack.append(li[ord(i) - 65])
print(f'{stack[-1] :.2f}')