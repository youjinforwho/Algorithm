S = input()
stack = []
for i in range(len(S)):
    if stack:
        if S[i] == ')' and stack[-1] == '(':
            stack.pop()
        else:
            stack.append(S[i])
    else:
        stack.append(S[i])
print(len(stack))