n = int(input())
cur = cnt = 1
while cur < n:
    cur += 6 * cnt
    cnt += 1
print(cnt)