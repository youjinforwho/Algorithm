from collections import deque
n = int(input())
FQ = []
FQ = deque(FQ)
dic = {}
res = []
for i in range(n):
    a = list(map(str, input().split()))
    if len(a) == 2:
        FQ.append(a[1])
        if dic.get(a[1], 0) == 0:
            dic[a[1]] = 1
        else:
            dic[a[1]] += 1
    else:
        if len(FQ) == 0:
            print('*')
        else:
            ptr = 0
            max_val = max(dic.values())
            while (dic[FQ[ptr]] != max_val):
                ptr += 1
            res.append(FQ[ptr])
            dic[FQ[ptr]] -= 1
            del FQ[ptr]
for i in res:
    print(i, end = ' ')      