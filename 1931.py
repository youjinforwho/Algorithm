n = int(input())
meeting = []
for i in range(n):
    s, e = map(int, input().split())
    meeting.append((s, e))
meeting.sort(key = lambda x : (x[1], x[0]))
last = meeting[0][0]
cnt = 0
for i in range(n):
    if meeting[0][0] >= last:
        last = meeting[0][1]
        cnt += 1
    meeting.pop(0)
print(cnt)