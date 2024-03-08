import sys
input = sys.stdin.readline
# x좌표 따로, y좌표 따로 보기
if __name__ == "__main__":    
    w, h = map(int, input().split())
    p, q = map(int, input().split())
    t= int(input())

    x = (p + t) // w
    y = (q + t) // h

    if x % 2 == 0:
        x = (p + t) % w
    else:
        x = w - (p + t) % w
    if y % 2 == 0:
        y = (q + t) % h
    else:
        y = h - (q + t) % h

    print(x, y)