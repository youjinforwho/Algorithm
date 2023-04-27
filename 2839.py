n = int(input())
kg_5 = n // 5
extra = n % 5
while (extra % 3 != 0 and extra != 0):
    kg_5 -= 1
    extra = n - kg_5 * 5
if extra == 0 and n // 5 == kg_5:
    print(kg_5)
elif extra == 0 or kg_5 < 0:
    print(-1)
else:
    print(kg_5 + (extra // 3))