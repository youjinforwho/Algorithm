def compute_mass(s):
    if s == 'H':
        return 1
    elif s == 'C':
        return 12
    elif s == 'O':
        return 16
    else:
        return 0
    
S = input()
stack = []
sum = res = 0
element = 0
for i in range(len(S)):
    if stack:
        if compute_mass(S[i]) > 0:
            stack.append(S[i])
            sum += compute_mass(S[i])
        else:
            #')'이거나 숫자인 경우
            if S[i] == '(':
                res += sum
                sum = 0
                stack.append(S[i])
            elif S[i] == ')':
                while (stack[-1] != '('):
                    stack.pop()
                stack.pop()
                res += sum
                temp = sum
                sum = 0
            else:
                sum += compute_mass(stack[-1]) * (int(S[i]) - 1)
    else:#'('이거나 숫자인 경우
        if S[i] == '(' or i == 0:
            stack.append(S[i])
            if compute_mass(S[i]) > 0:
                sum += compute_mass(S[i])
        else:#숫자인 경우
            res += temp * (int(S[i]) - 1)
print(res)