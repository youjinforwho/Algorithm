li = list(map(int, input().split()))
res = 0
for i in li:
    res += i * i
print(res % 10)