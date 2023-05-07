from collections import deque
case = int(input())
for i in range(case):
    cnt = 0
    n, m = map(int, input().split())
    dq = [(pos, val) for pos, val in enumerate(list(map(int, input().split())))] 
    dq = deque(dq)
    while dq:
        cur = dq.popleft()
        if any(cur[1] < x[1] for x in dq):
            dq.append(cur)
        else:
            cnt += 1
            if cur[0] == m:
                print(cnt)
                break