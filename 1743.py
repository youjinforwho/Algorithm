import sys
from collections import deque

input = sys.stdin.readline
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def BFS(i, j, trash):
    q = deque([[i, j]])
    garbage[i][j] = 2
    res = 1 #음식물 크기 1로 지정

    while q: #음식물이 있을때까지 탐색
        x, y = q.popleft()

        for d in range(4): #해당 좌표의 상하좌우 탐색
            if 0 < x + dx[d] <= N and 0 < y + dy[d] <= M and trash[x + dx[d]][y + dy[d]] == 1:
                q.append([x + dx[d], y + dy[d]])
                garbage[x + dx[d]][y + dy[d]] = 2
                res += 1
    return res


if __name__ == "__main__":
    N, M, K = map(int, input().split())
    garbage = [[0] * (M + 1) for _ in range(N + 1)]
    answer = 0

    for _ in range(K):
        x, y = map(int, input().split())
        garbage[x][y] = 1
    
    for i in range(1, N + 1):
        for j in range(1, M + 1):
            if garbage[i][j] == 1: #해당 좌표에 음식물이 있으면
                ans = BFS(i, j ,garbage) #해당 좌표를 기준으로 너비 우선 탐색
                answer = max(ans, answer) #음식물 크기 비교
    print(answer)
