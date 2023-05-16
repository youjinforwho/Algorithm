import sys
input = sys.stdin.readline
def preOrder(v):
    chk = cv_li.get(v, -1)
    if chk == -1:
        return
    else:
        print(cv_li[v], end = '')
        preOrder(v * 2 + 1) #왼쪽 자식 노드 호출
        preOrder(v * 2 + 2) #오른쪽 자식 노드 호출

def inOrder(v):
    chk = cv_li.get(v, -1)
    if chk == -1:
        return
    else:
        inOrder(v * 2 + 1) #왼쪽 자식 노드 호출
        print(cv_li[v], end = '')
        inOrder(v * 2 + 2) #오른쪽 자식 노드 호출

def postOrder(v):
    chk = cv_li.get(v, -1)
    if chk == -1:
        return
    else:
        postOrder(v * 2 + 1) #왼쪽 자식 노드 호출
        postOrder(v * 2 + 2) #오른쪽 자식 노드 호출
        print(cv_li[v], end = '')

if __name__ == "__main__":
    n = int(input())
    li = dict()
    li['A'] = 0
    for i in range(n):
        pr, lc, rc = map(str, input().split())
        if lc != '.':
            li[lc] = li.get(pr, 0) * 2 + 1
        if rc != '.':
            li[rc] = li.get(pr, 0) * 2 + 2
    cv_li = {v : k for k, v in li.items()}
    preOrder(0)
    print()
    inOrder(0)
    print()
    postOrder(0)