# https://teching.tistory.com/
n = int(input())
cnt = 0
def nQueen(placed):
    global n, cnt
    low = len(placed)
    if low == n:
        cnt += 1
    else:
        #해당 루트가 가능성이 있는지 확인.
        can = [1 for i in range(n)]
        for i in range(low):
            can[placed[i]] = 0
            #대각선
            if placed[i]+(low-i) < n :
                can[placed[i]+(low-i)] = 0
            if placed[i]-(low-i) >= 0 :
                can[placed[i]-(low-i)] = 0
        for i in range(n):
            if can[i]:
                placed.append(i)
                nQueen(placed)
                placed.pop()

nQueen([])
print(cnt)