import sys
input = sys.stdin.readline
n = int(input())
book = [[0] * 2 for _ in range(n)]
for i in range(n):
    a, b = map(int, input().split())
    book[i][0] = a
    book[i][1] = b
book.sort(reverse = True)
if book[-1][0] == 0:
    please = book[-1][1]
    book.pop()
    while (book and please >= 0):
        if please - book[-1][0] >= 0:
            please = please - book[-1][0] + book[-1][1]
            book.pop()
        elif please - book[-1][0] < 0 and len(book) == 1:
            break
        else:
            book.insert(0, book.pop())
    if please >= 0 and len(book) == 0:
        print(1)
    else:
        print(0)
else:
    print(0)
    sys.exit()
