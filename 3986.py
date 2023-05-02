def check_good(word):
    stack = []
    for i in range(len(word)):
        if stack:
            if word[i] == 'A' and stack[-1] == 'A':
                stack.pop()
            elif word[i] == 'B' and stack[-1] == 'B':
                stack.pop()
            else:
                stack.append(word[i])
        else:
            stack.append(word[i])
    if len(stack) == 0:
        return 1
    else:
        return 0
    
n = int(input())
cnt = 0
for i in range(n):
    word = input()
    if check_good(word) == 1:
        cnt += 1
print(cnt)