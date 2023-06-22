n = int(input())
record = {}
for i in range(n):
    name, order = map(str, input().split())
    if order == "enter":
        record[name] = 1
    elif order == "leave":
        del record[name]
res = sorted(record.items())
for i in range(len(res)):
    print(res[-(i + 1)][0])
