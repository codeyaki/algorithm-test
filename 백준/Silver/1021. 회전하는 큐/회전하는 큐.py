#https://teching.tistory.com/
import sys
from collections import deque
n, m = map(int, sys.stdin.readline().split())
wantIdxs = list(map(lambda x: int(x)-1, sys.stdin.readline().split()))
que = deque(range(n))
answer = 0
for wi in wantIdxs:
    idx = que.index(wi)
    if idx > len(que)//2:
        idx = -(len(que) - idx)
        answer -= idx
    else:
        answer += idx
    que.rotate(-idx)
    que.popleft()
print(answer)