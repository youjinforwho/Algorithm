def cal(n, cnt):
    if n <= 0:
        return 2e9
    while (n != 1):
        if n % 3 == 0:
            n /= 3
            cnt += 1
        elif n % 2 == 0:
            n /= 2
            cnt += 1
        else:
            n -= 1
            cnt += 1
    return cnt
import sys
input = sys.stdin.readline
num = int(input())
res = []
for i in range(3):
    res.append(cal(num - i, 0 + i))
print(min(res))