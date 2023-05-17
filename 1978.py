def is_prime(x):
    num = 2
    if x == 1:
        return 0
    while (num * num <= x):
        if x % num == 0:
            return 0
        num += 1
    else:
        return 1
cnt = 0
n = int(input())
arr = list(map(int, input().split()))
for i in range(n):
    if is_prime(arr[i]) == 1:
        cnt += 1
print(cnt)