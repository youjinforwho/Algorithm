S = int(input())
sum = cnt = 0
i = 1
while (S - sum >= i):
    sum += i
    i += 1
    cnt += 1
else:
    print(cnt)
