#https://teching.tistory.com/
import sys
cntWhite = 0
cntBlue = 0
def makeConftti(paper):
    global cntBlue, cntWhite
    tmp = 0
    for line in paper:
        tmp += sum(line)
    n = len(paper)
    if tmp == n*n:
        cntBlue += 1
        return
    elif tmp == 0:
        cntWhite += 1
        return
    #가로 세로 쪼개기
    splitPaper1 =[]
    splitPaper2 =[]
    splitPaper3 =[]
    splitPaper4 =[]
    for i in range(n):
        if i <= n//2 - 1 :
            splitPaper1.append(paper[i][:n//2])
            splitPaper2.append(paper[i][n//2:])
        if i > n//2 - 1:
            splitPaper3.append(paper[i][:n//2])
            splitPaper4.append(paper[i][n//2:])
    makeConftti(splitPaper1)
    makeConftti(splitPaper2)
    makeConftti(splitPaper3)
    makeConftti(splitPaper4)


n = int(sys.stdin.readline().rstrip())
inputPaper = []
for _ in range(n):
    inputPaper.append(list(map(int,sys.stdin.readline().split())))
makeConftti(inputPaper)
print(cntWhite)
print(cntBlue)