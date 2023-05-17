n = int(input())
word = {}
for i in range(n):
    x = input()
    word[x] = len(x)
a = sorted(word.items(), key = lambda x : (x[1], x[0]))
for i in a:
    print(i[0])