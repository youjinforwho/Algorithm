a, b, v = map(int, input().split())
dalpeng = a
day = 1
if dalpeng < v:
    v -= dalpeng
    day += v // (a - b)
    if (v / (a - b) - v // (a - b)) > 0:
        day += 1
print(day)