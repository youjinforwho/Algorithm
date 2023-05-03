N, S = map(int, input().split())
a = list(map(int, input().split()))
l = [a[0]]
res = []
for i in range(1, len(a)):
    l.append(l[-1] + a[i])
for i in range(len(a)):
    for j in range(i, len(a)): #i부터 j까지 구간 합 구하기
        if l[j] > S:
            break
        if i == 0:
            res.append(l[j])
        else:
            res.append(l[j] - l[i - 1])
        if res[-1] == S:
            print(j - i + 1)
            break
        else:
            res.pop()
    if res:
        break
if not res:
    print(0)
