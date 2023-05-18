T = int(input())
apt = [[0] * 14 for _ in range(15)]
apt[0][:15] = [(i + 1) for i in range(14)]
for i in range(15):
    apt[i][0] = 1
for i in range(1, 15):
    for j in range(1, 14):
        apt[i][j] = apt[i - 1][j] + apt[i][j - 1]
for i in range(T):
    k = int(input())
    n = int(input())
    print(apt[k][n - 1])