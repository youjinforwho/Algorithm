X = int(input())
N = int(input())
price = 0
for i in range(N):
    a, b = map(int, input().split())
    price += a * b
if price == X:
    print("Yes")
else:
    print("No")