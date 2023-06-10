def DFS(n, m, check):
    global cnt
    flag = True
    if n - 1 >= 0 and a[n - 1][m] == 1:
        a[n][m] = 0
        DFS(n - 1, m, check)
        flag = False
    if m - 1 >= 0 and a[n][m - 1] == 1:
        a[n][m] = 0
        DFS(n, m - 1, check)
        flag = False
    if n + 1 < N and a[n + 1][m] == 1:
        a[n][m] = 0
        DFS(n + 1, m, check)
        flag = False
    if m + 1 < M and a[n][m + 1] == 1:
        a[n][m] = 0
        DFS(n, m + 1, check)
        flag = False
    if flag == True and check == 0:
        check = 1
        a[n][m] = 0


import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

T = int(input())
for i in range(T):
    cnt = 0
    M, N, K = map(int, input().split())
    a = [[0] * M for _ in range(N)]
    for i in range(K):
        x, y = map(int, input().split())
        a[y][x] = 1
    for s in range(N):
        for k in range(M):
            if a[s][k] == 1:
                DFS(s, k, 0)
                cnt += 1
    print(cnt)
