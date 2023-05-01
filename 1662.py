S = input()
stack = ""
num = 0
words = []
Q = []
res = ""
for i in range(0, len(S)):
    if S[i] == '(':
        stack = ""
    elif S[i] == ')':
        #words.append(stack)
        print(res)
        print(Q[-1])
        print(stack)
        res = Q[-1] * stack
        stack += words[-1]
        Q.pop()
        words.pop()
    else:
        if S[i + 1] == '(':
            Q.append(int(i))
            words.append(stack)
        else:
            stack += S[i]
print(len(res))