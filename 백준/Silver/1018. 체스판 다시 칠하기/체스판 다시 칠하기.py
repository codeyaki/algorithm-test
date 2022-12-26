#https://teching.tistory.com/
import sys
import sys
N, M = map(int,sys.stdin.readline().split())
board = [[m for m in sys.stdin.readline().rstrip()] for _ in range(N)]
case1 = [[0 for _ in range(M)] for _ in range(N)]
case2 = [[0 for _ in range(M)] for _ in range(N)]
for n in range(N):
    for m in range(M):
        if (n+m)%2 == 0:
            if board[n][m] == 'W': case2[n][m] = 1
            else: case1[n][m] = 1
        else:
            if board[n][m] == 'W': case1[n][m] = 1
            else: case2[n][m] = 1

answer = 50*50
for a in range(N-7):
    for b in range(M-7):
        white = sum([case1[i][j] for i in range(a,a+8) for j in range(b,b+8)])
        black = sum([case2[i][j] for i in range(a,a+8) for j in range(b,b+8)])
        answer = min(answer, white, black)
        if answer == 0 : break
print(answer)