word = input()
dic = {}
for i in word:
    if dic.get(i.upper(), 0) == 0:
        dic[i.upper()] = 1
    else:
        dic[i.upper()] += 1
res = sorted(dic.items(), key = lambda x : x[1])
if len(res) > 1 and res[-1][1] == res[-2][1]:
    print("?")
else:
    print(res[-1][0])