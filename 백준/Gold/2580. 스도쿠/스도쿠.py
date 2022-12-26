import sys
board = []
answerCnt = 0
empty = []
emptyLoc = []
for i in range(9):
    line = list(map(int,sys.stdin.readline().split()))
    board.append(line)
    for j in range(9):
        if line[j] == 0:
            empty.append(0)
            emptyLoc.append([i, j])

def sudoku(idx):
    global answerCnt
    if answerCnt == 0:
        #이전 빈칸들 채워넣기
        for i in range(idx-1,len(emptyLoc)):
            board[emptyLoc[i][0]][emptyLoc[i][1]] = empty[i]
        #출력
        if idx == len(empty):
            answerCnt += 1
            for line in board:
                print(*line)
            return
        #채울 빈칸 위치
        spot = emptyLoc[idx]
        #스도쿠 빈칸 채우기
        garo = set()
        sero = set()
        square= set()
        for i in range(9):
            if board[spot[0]][i] >0:
                garo.add(board[spot[0]][i])
            if board[i][spot[1]] >0:
                sero.add(board[i][spot[1]])
        for i in range((spot[0]//3)*3,(spot[0]//3)*3+3):
            for j in range((spot[1]//3)*3,(spot[1]//3)*3+3):
                if board[i][j] >0:
                    square.add(board[i][j])
        can = {1,2,3,4,5,6,7,8,9} - (garo|sero|square)
        for i in can:
            empty[idx] = i
            sudoku(idx+1)
            empty[idx] = 0

sudoku(0)