import sys
read = sys.stdin.readline

T = int(read())
for i in range(T):
    cnt = 0
    M, N, K = map(int, read().split())
    a = [[0] * M for _ in range(N)]
    for i in range(K):
        x, y = map(int, read().split())
        a[y][x] = 1
    for s in range(N):
        for k in range(M):
            if a[s][k] == 1:
                if s - 1 >= 0 and k - 1 >= 0 and a[s - 1][k] == 0 and a[s][k - 1] == 0:
                    cnt += 1
                elif s - 1 >= 0 and k - 1 < 0 and a[s - 1][k] == 0:
                    cnt += 1
                elif s - 1 < 0 and k - 1 >= 0 and a[s][k - 1] == 0:
                    cnt += 1
                elif s - 1 < 0 and k - 1 < 0:
                    cnt += 1
    print(cnt)
