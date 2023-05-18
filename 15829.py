L = int(input())
s = input()
res = 0
for i in range(L):
    res += (ord(s[i]) - 96) * (31 ** i)
print(res % 1234567891)