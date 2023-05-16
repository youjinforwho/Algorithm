while True:
    stack = []
    s = input()
    if s == ".":
        break
    for i in s:
        if i == '[':
            stack.append(i)
        elif i == ']':
            if stack and stack[-1] == '[':
                stack.pop()
            else:
                stack.append(i)
        elif i == '(':
            stack.append(i)
        elif i == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(i)
    if len(stack) == 0:
        print("yes")
    else:
        print("no")
