rec = {}
imo = 0
n = int(input())
for i in range(n):
    s = input()
    if s == "ENTER":
        rec = {}
    else:
        chk = rec.get(s, 0)
        if chk == 0:
            rec[s] = 0
            imo += 1
        rec[s] += 1
print(imo)
