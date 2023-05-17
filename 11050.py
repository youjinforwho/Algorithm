def fac(x):
    if x == 0 or x == 1:
        return 1
    else:
        return x * fac(x - 1)
n, k = map(int, input().split())
if k > n - k:
    k = n - k
res = 1
for i in range(k):
    res *= n
    n -= 1
print(int(res / fac(k)))