def new_round(num):
  if num - int(num) >= 0.5:
    return int(num) + 1
  else:
    return int(num)

n = int(input())
li = []
for _ in range(n):
  li.append(int(input()))

std = new_round(n * 0.15) 
li.sort()
if n - std * 2 <= 0:
    print(0)
elif std == 0:
   print(new_round(sum(li) / len(li)))
elif n - std * 2 == 1:
   print(li[std])
else:
    print(new_round(sum(li[std : -std]) / (n - std * 2)))