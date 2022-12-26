#https://teching.tistory.com/
import sys

cnt = {
    -1: 0,
    0: 0,
    1: 0
}


def check(x, y, n, paper):
    if n == 1:
        return True
    plag = paper[y][x]
    for i in range(y, y + n):
        for j in range(x, x + n):
            if plag != paper[i][j]:
                return False
    return True


def paper_split(x, y, n, paper):
    if check(x, y, n, paper):
        cnt[paper[y][x]] += 1
        return
    n //= 3
    for _ in range(3):
        paper_split(x, y, n, paper)
        paper_split(x + n, y, n, paper)
        paper_split(x + n*2, y, n, paper)
        y += n


n = int(sys.stdin.readline().rstrip())
inPaper = []
for _ in range(n):
    inPaper.append(list(map(int, sys.stdin.readline().split())))
paper_split(0, 0, n, inPaper)
for key in cnt:
    print(cnt[key])
