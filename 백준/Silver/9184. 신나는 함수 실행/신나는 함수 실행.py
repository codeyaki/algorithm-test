import sys

memoization = [[[0 for _ in range(21)] for _ in range(21)] for _ in range(21)]
def w(a,b,c):
    global memoization
    if a <= 0 or b <= 0 or c <= 0:
        return 1
    elif a>20 or b>20 or c>20:
        return w(20,20,20)
    elif memoization[a][b][c] == 0:
        if a<b and b<c:
            memoization[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c)
        else:
            memoization[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1)
    return memoization[a][b][c]

for line in sys.stdin:
    A,B,C = map(int,line.split())
    if A == -1 and B == -1 and C == -1: break
    print(f"w({A}, {B}, {C}) = {w(A,B,C)}")
